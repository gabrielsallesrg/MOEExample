package moeexample.ui;

import com.example.models.RandomUser;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.general.ann.RegisterOnStartup;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.IBAction;
import org.moe.natj.objc.ann.IBOutlet;
import org.moe.natj.objc.ann.ObjCClassName;
import org.moe.natj.objc.ann.Property;
import org.moe.natj.objc.ann.Selector;

import apple.foundation.NSData;
import apple.foundation.NSURL;
import apple.uikit.UIButton;
import apple.uikit.UIImage;
import apple.uikit.UIImageView;
import apple.uikit.UILabel;
import apple.uikit.UIViewController;
import apple.uikit.enums.UIControlEvents;

@org.moe.natj.general.ann.Runtime(ObjCRuntime.class)
@ObjCClassName("DetailViewController")
@RegisterOnStartup
public class DetailViewController extends UIViewController {

    static {
        NatJ.register();
    }

//    @Selector("detailButton")
//    @Property
//    @IBOutlet
//    public native UIButton button();

    RandomUser mRandomUser;

    @Selector("userImage")
    @Property
    @IBOutlet
    public native UIImageView userImage();

    @Selector("fullName")
    @Property
    @IBOutlet
    public native UILabel fullName();

    @Selector("address")
    @Property
    @IBOutlet
    public native UILabel address();

    @Selector("homeNumber")
    @Property
    @IBOutlet
    public native UILabel homeNumber();

    @Selector("mobileNumber")
    @Property
    @IBOutlet
    public native UILabel mobileNumber();

    @Selector("email")
    @Property
    @IBOutlet
    public native UILabel email();

    protected DetailViewController(Pointer peer) {
        super(peer);
    }

    @Generated("NatJ")
    @Owned
    @Selector("alloc")
    public static native DetailViewController alloc();

    @Generated("NatJ")
    @Owned
    @Selector("init")
    public native DetailViewController init();


    @Selector("viewDidLoad")
    @Override
    public void viewDidLoad() {
        NSURL imageUrl = NSURL.URLWithString(mRandomUser.getPicture().getLarge());
        NSData data = NSData.dataWithContentsOfURL(imageUrl);
        userImage().initWithImage(UIImage.imageWithData(data));
        fullName().setText(mRandomUser.getFullName());
        address().setText(mRandomUser.getFullAddress());
        homeNumber().setText(mRandomUser.getPhone());
        mobileNumber().setText(mRandomUser.getCell());
        email().setText(mRandomUser.getEmail());
//        button().addTargetActionForControlEvents(this, new SEL("buttonPressed"), UIControlEvents.TouchUpInside);
    }

//    @Selector("buttonPressed")
//    @IBAction
//    public void buttonPressed(UIButton button) {
//        this.button().setHidden(true);
//    }

}































