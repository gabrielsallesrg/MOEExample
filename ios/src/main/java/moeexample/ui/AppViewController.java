package moeexample.ui;

import android.util.Log;

import com.example.interfaces.RandomUsersView;
import com.example.models.RandomUser;
import com.example.models.RandomUsersData;
import com.example.presenters.RandomUserPresenter;
import com.moeexample.sdwebimage.SDImageCache;

import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.general.ann.RegisterOnStartup;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.IBOutlet;
import org.moe.natj.objc.ann.ObjCClassName;
import org.moe.natj.objc.ann.Property;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

import java.util.ArrayList;
import java.util.List;

import apple.foundation.NSArray;
import apple.foundation.NSData;
import apple.foundation.NSIndexPath;
import apple.foundation.NSOperationQueue;
import apple.foundation.NSURL;
import apple.foundation.enums.NSQualityOfService;
import apple.uikit.UIActivityIndicatorView;
import apple.uikit.UIImage;
import apple.uikit.UIStoryboardSegue;
import apple.uikit.UITableView;
import apple.uikit.UITableViewCell;
import apple.uikit.UIViewController;
import apple.uikit.enums.UITableViewRowAnimation;
import apple.uikit.protocol.UITableViewDataSource;
import apple.uikit.protocol.UITableViewDelegate;
import moeexample.rx.schedulers.IOSSchedulers;



import static apple.c.Globals.dispatch_async;
import static apple.c.Globals.dispatch_get_global_queue;

@org.moe.natj.general.ann.Runtime(ObjCRuntime.class)
@ObjCClassName("AppViewController")
@RegisterOnStartup
public class AppViewController extends UIViewController implements RandomUsersView, UITableViewDataSource, UITableViewDelegate {

    private static final String CELL_IDENTIFIER = "listingTableViewCell";
    private final NSOperationQueue operationQueue;
    private int mPage = 0;
    private boolean isLoading = false;
    private RandomUserPresenter mRandomUserPresenter;

    private List<RandomUser> mRandomUsers = new ArrayList<>();

    @Selector("tableView")
    @Property
    @IBOutlet
    public native UITableView tableView();

    @Selector("loading")
    @Property
    @IBOutlet
    public native UIActivityIndicatorView loadingView();

    @Owned
    @Selector("alloc")
    public static native AppViewController alloc();

    @Selector("init")
    public native AppViewController init();

    protected AppViewController(Pointer peer) {
        super(peer);
        operationQueue = NSOperationQueue.alloc().init();
        operationQueue.setQualityOfService(NSQualityOfService.Background);
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        loadingView().startAnimating();
        tableView().setHidden(true);
        mRandomUserPresenter = new RandomUserPresenter(this);
        mRandomUserPresenter.getRandomUsers(IOSSchedulers.mainThread(), IOSSchedulers.handlerThread(operationQueue), mPage);
        isLoading = true;
    }

    @Override
    public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        UITableViewCell cell = tableView.dequeueReusableCellWithIdentifier(CELL_IDENTIFIER);
        int pos = (int) indexPath.row();
        String text = mRandomUsers.get(pos).getFullName();
        cell.textLabel().setText(text);

        String urlString = mRandomUsers.get(pos).getPicture().getThumbnail();

        // If the image is cached already
        if (SDImageCache.sharedImageCache().diskImageExistsWithKey(urlString)) {
            UIImage image = SDImageCache.sharedImageCache().imageFromDiskCacheForKey(urlString);
            cell.imageView().initWithImage(image);
        } else {
            cell.imageView().initWithImage(UIImage.imageNamed("ic_account"));

            dispatch_async(dispatch_get_global_queue(0, 0), () -> {
                NSURL imageUrl = NSURL.URLWithString(urlString);
                NSData data = NSData.dataWithContentsOfURL(imageUrl);
                cell.imageView().initWithImage(UIImage.imageWithData(data));
                SDImageCache.sharedImageCache().storeImageForKey(cell.imageView().image(), urlString);
                Log.d("LOADED IMAGE", String.valueOf(pos) + " " + mRandomUsers.get(pos).getPicture().getThumbnail());
            });
        }


        return cell;
    }

    @Override
    public long tableViewNumberOfRowsInSection(UITableView tableView, @NInt long section) {
        return mRandomUsers.size();
    }

    @Override
    public long numberOfSectionsInTableView(UITableView tableView) {
        return 1;
    }

    @Override
    public void tableViewDidSelectRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        tableView.deselectRowAtIndexPathAnimated(indexPath, true);
        performSegueWithIdentifierSender("detail", mRandomUsers.get((int)indexPath.row()));
    }

    @Override
    public void tableViewWillDisplayCellForRowAtIndexPath(UITableView tableView, UITableViewCell cell, NSIndexPath indexPath) {
        if ((int)indexPath.row() == mRandomUsers.size() - 1 && !isLoading) {
            isLoading = true;
            loadingView().setHidden(false);
            mPage++;
            mRandomUserPresenter.getRandomUsers(IOSSchedulers.mainThread(), IOSSchedulers.handlerThread(operationQueue), mPage);
        }
    }

    @Override
    public void showRandomUser(RandomUsersData randomUsersData) {
        int arraySize = mRandomUsers.size();
        for (RandomUser randomUser: randomUsersData.getResults()) {
            mRandomUsers.add(randomUser);
            NSArray indexPath = NSArray.arrayWithObject(NSIndexPath.indexPathForRowInSection(arraySize++, 0));
            tableView().insertRowsAtIndexPathsWithRowAnimation(indexPath, UITableViewRowAnimation.Automatic);
        }

        tableView().setHidden(false);
        loadingView().setHidden(true);
        isLoading = false;
    }

    @Override
    public void prepareForSegueSender(UIStoryboardSegue segue, @Mapped(ObjCObjectMapper.class) Object sender) {
        super.prepareForSegueSender(segue, sender);
        DetailViewController detailVC = (DetailViewController) segue.destinationViewController();
        detailVC.mRandomUser = (RandomUser) sender;
    }
}
