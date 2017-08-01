package com.moeexample.sdwebimage;


import apple.NSObject;
import apple.foundation.NSArray;
import apple.foundation.NSError;
import apple.foundation.NSMethodSignature;
import apple.foundation.NSSet;
import apple.foundation.NSURL;
import apple.uikit.UIImage;
import com.moeexample.sdwebimage.protocol.SDWebImageManagerDelegate;
import com.moeexample.sdwebimage.protocol.SDWebImageOperation;
import org.moe.natj.c.ann.FunctionPtr;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.MappedReturn;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.general.ann.NUInt;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.objc.Class;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.ObjCBlock;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Library("SDWebImage")
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class SDWebImageManager extends NSObject {
	static {
		NatJ.register();
	}

	@Generated
	protected SDWebImageManager(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Owned
	@Selector("alloc")
	public static native SDWebImageManager alloc();

	@Generated
	@Selector("allocWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object allocWithZone(VoidPtr zone);

	@Generated
	@Selector("automaticallyNotifiesObserversForKey:")
	public static native boolean automaticallyNotifiesObserversForKey(String key);

	@Generated
	@Selector("cacheKeyFilter")
	@ObjCBlock(name = "call_cacheKeyFilter_ret")
	public native Block_cacheKeyFilter_ret cacheKeyFilter();

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_cacheKeyFilter_ret {
		@Generated
		String call_cacheKeyFilter_ret(NSURL arg0);
	}

	@Generated
	@Selector("cacheKeyForURL:")
	public native String cacheKeyForURL(NSURL url);

	@Generated
	@Selector("cachedImageExistsForURL:")
	public native boolean cachedImageExistsForURL(NSURL url);

	@Generated
	@Selector("cachedImageExistsForURL:completion:")
	public native void cachedImageExistsForURLCompletion(
			NSURL url,
			@ObjCBlock(name = "call_cachedImageExistsForURLCompletion") Block_cachedImageExistsForURLCompletion completionBlock);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_cachedImageExistsForURLCompletion {
		@Generated
		void call_cachedImageExistsForURLCompletion(boolean arg0);
	}

	@Generated
	@Selector("cancelAll")
	public native void cancelAll();

	@Generated
	@Selector("cancelPreviousPerformRequestsWithTarget:")
	public static native void cancelPreviousPerformRequestsWithTarget(
			@Mapped(ObjCObjectMapper.class) Object aTarget);

	@Generated
	@Selector("cancelPreviousPerformRequestsWithTarget:selector:object:")
	public static native void cancelPreviousPerformRequestsWithTargetSelectorObject(
			@Mapped(ObjCObjectMapper.class) Object aTarget, SEL aSelector,
			@Mapped(ObjCObjectMapper.class) Object anArgument);

	@Generated
	@Selector("class")
	public static native Class class_objc_static();

	@Generated
	@Selector("classFallbacksForKeyedArchiver")
	public static native NSArray<String> classFallbacksForKeyedArchiver();

	@Generated
	@Selector("classForKeyedUnarchiver")
	public static native Class classForKeyedUnarchiver();

	@Generated
	@Selector("debugDescription")
	public static native String debugDescription_static();

	@Generated
	@Selector("delegate")
	@MappedReturn(ObjCObjectMapper.class)
	public native SDWebImageManagerDelegate delegate();

	@Generated
	@Selector("description")
	public static native String description_static();

	@Generated
	@Selector("diskImageExistsForURL:")
	public native boolean diskImageExistsForURL(NSURL url);

	@Generated
	@Selector("diskImageExistsForURL:completion:")
	public native void diskImageExistsForURLCompletion(
			NSURL url,
			@ObjCBlock(name = "call_diskImageExistsForURLCompletion") Block_diskImageExistsForURLCompletion completionBlock);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_diskImageExistsForURLCompletion {
		@Generated
		void call_diskImageExistsForURLCompletion(boolean arg0);
	}

	@Generated
	@Selector("downloadImageWithURL:options:progress:completed:")
	@MappedReturn(ObjCObjectMapper.class)
	public native SDWebImageOperation downloadImageWithURLOptionsProgressCompleted(
			NSURL url,
			@NUInt long options,
			@ObjCBlock(name = "call_downloadImageWithURLOptionsProgressCompleted_2") Block_downloadImageWithURLOptionsProgressCompleted_2 progressBlock,
			@ObjCBlock(name = "call_downloadImageWithURLOptionsProgressCompleted_3") Block_downloadImageWithURLOptionsProgressCompleted_3 completedBlock);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_downloadImageWithURLOptionsProgressCompleted_2 {
		@Generated
		void call_downloadImageWithURLOptionsProgressCompleted_2(
				@NInt long arg0, @NInt long arg1);
	}

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_downloadImageWithURLOptionsProgressCompleted_3 {
		@Generated
		void call_downloadImageWithURLOptionsProgressCompleted_3(UIImage arg0,
				NSError arg1, @NInt long arg2, boolean arg3, NSURL arg4);
	}

	@Generated
	@Deprecated
	@Selector("downloadWithURL:options:progress:completed:")
	@MappedReturn(ObjCObjectMapper.class)
	public native SDWebImageOperation downloadWithURLOptionsProgressCompleted(
			NSURL url,
			@NUInt long options,
			@ObjCBlock(name = "call_downloadWithURLOptionsProgressCompleted_2") Block_downloadWithURLOptionsProgressCompleted_2 progressBlock,
			@ObjCBlock(name = "call_downloadWithURLOptionsProgressCompleted_3") Block_downloadWithURLOptionsProgressCompleted_3 completedBlock);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_downloadWithURLOptionsProgressCompleted_2 {
		@Generated
		void call_downloadWithURLOptionsProgressCompleted_2(@NInt long arg0,
				@NInt long arg1);
	}

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_downloadWithURLOptionsProgressCompleted_3 {
		@Generated
		void call_downloadWithURLOptionsProgressCompleted_3(UIImage arg0,
				NSError arg1, @NInt long arg2, boolean arg3);
	}

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("imageCache")
	public native SDImageCache imageCache();

	@Generated
	@Selector("imageDownloader")
	public native SDWebImageDownloader imageDownloader();

	@Generated
	@Selector("init")
	public native SDWebImageManager init();

	@Generated
	@Selector("initWithCache:downloader:")
	public native SDWebImageManager initWithCacheDownloader(SDImageCache cache,
			SDWebImageDownloader downloader);

	@Generated
	@Selector("initialize")
	public static native void initialize();

	@Generated
	@Selector("instanceMethodForSelector:")
	@FunctionPtr(name = "call_instanceMethodForSelector_ret")
	public static native NSObject.Function_instanceMethodForSelector_ret instanceMethodForSelector(
			SEL aSelector);

	@Generated
	@Selector("instanceMethodSignatureForSelector:")
	public static native NSMethodSignature instanceMethodSignatureForSelector(
			SEL aSelector);

	@Generated
	@Selector("instancesRespondToSelector:")
	public static native boolean instancesRespondToSelector(SEL aSelector);

	@Generated
	@Selector("isRunning")
	public native boolean isRunning();

	@Generated
	@Selector("isSubclassOfClass:")
	public static native boolean isSubclassOfClass(Class aClass);

	@Generated
	@Selector("keyPathsForValuesAffectingValueForKey:")
	public static native NSSet<String> keyPathsForValuesAffectingValueForKey(
			String key);

	@Generated
	@Selector("load")
	public static native void load_objc_static();

	@Generated
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("resolveClassMethod:")
	public static native boolean resolveClassMethod(SEL sel);

	@Generated
	@Selector("resolveInstanceMethod:")
	public static native boolean resolveInstanceMethod(SEL sel);

	@Generated
	@Selector("saveImageToCache:forURL:")
	public native void saveImageToCacheForURL(UIImage image, NSURL url);

	@Generated
	@Selector("setCacheKeyFilter:")
	public native void setCacheKeyFilter(
			@ObjCBlock(name = "call_setCacheKeyFilter") Block_setCacheKeyFilter value);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_setCacheKeyFilter {
		@Generated
		String call_setCacheKeyFilter(NSURL arg0);
	}

	@Generated
	@Selector("setDelegate:")
	public native void setDelegate_unsafe(
			@Mapped(ObjCObjectMapper.class) SDWebImageManagerDelegate value);

	@Generated
	public void setDelegate(
			@Mapped(ObjCObjectMapper.class) SDWebImageManagerDelegate value) {
		Object __old = delegate();
		if (value != null) {
			org.moe.natj.objc.ObjCRuntime.associateObjCObject(this, value);
		}
		setDelegate_unsafe(value);
		if (__old != null) {
			org.moe.natj.objc.ObjCRuntime.dissociateObjCObject(this, __old);
		}
	}

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("sharedManager")
	public static native SDWebImageManager sharedManager();

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();
}