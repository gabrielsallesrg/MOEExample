package com.moeexample.sdwebimage;


import apple.NSObject;
import apple.foundation.NSArray;
import apple.foundation.NSData;
import apple.foundation.NSMethodSignature;
import apple.foundation.NSOperation;
import apple.foundation.NSSet;
import apple.uikit.UIImage;
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
public class SDImageCache extends NSObject {
	static {
		NatJ.register();
	}

	@Generated
	protected SDImageCache(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Selector("addReadOnlyCachePath:")
	public native void addReadOnlyCachePath(String path);

	@Generated
	@Owned
	@Selector("alloc")
	public static native SDImageCache alloc();

	@Generated
	@Selector("allocWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object allocWithZone(VoidPtr zone);

	@Generated
	@Selector("automaticallyNotifiesObserversForKey:")
	public static native boolean automaticallyNotifiesObserversForKey(String key);

	@Generated
	@Selector("cachePathForKey:inPath:")
	public native String cachePathForKeyInPath(String key, String path);

	@Generated
	@Selector("calculateSizeWithCompletionBlock:")
	public native void calculateSizeWithCompletionBlock(
			@ObjCBlock(name = "call_calculateSizeWithCompletionBlock") Block_calculateSizeWithCompletionBlock completionBlock);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_calculateSizeWithCompletionBlock {
		@Generated
		void call_calculateSizeWithCompletionBlock(@NUInt long arg0,
				@NUInt long arg1);
	}

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
	@Selector("cleanDisk")
	public native void cleanDisk();

	@Generated
	@Selector("cleanDiskWithCompletionBlock:")
	public native void cleanDiskWithCompletionBlock(
			@ObjCBlock(name = "call_cleanDiskWithCompletionBlock") Block_cleanDiskWithCompletionBlock completionBlock);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_cleanDiskWithCompletionBlock {
		@Generated
		void call_cleanDiskWithCompletionBlock();
	}

	@Generated
	@Selector("clearDisk")
	public native void clearDisk();

	@Generated
	@Selector("clearDiskOnCompletion:")
	public native void clearDiskOnCompletion(
			@ObjCBlock(name = "call_clearDiskOnCompletion") Block_clearDiskOnCompletion completion);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_clearDiskOnCompletion {
		@Generated
		void call_clearDiskOnCompletion();
	}

	@Generated
	@Selector("clearMemory")
	public native void clearMemory();

	@Generated
	@Selector("debugDescription")
	public static native String debugDescription_static();

	@Generated
	@Selector("defaultCachePathForKey:")
	public native String defaultCachePathForKey(String key);

	@Generated
	@Selector("description")
	public static native String description_static();

	@Generated
	@Selector("diskImageExistsWithKey:")
	public native boolean diskImageExistsWithKey(String key);

	@Generated
	@Selector("diskImageExistsWithKey:completion:")
	public native void diskImageExistsWithKeyCompletion(
			String key,
			@ObjCBlock(name = "call_diskImageExistsWithKeyCompletion") Block_diskImageExistsWithKeyCompletion completionBlock);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_diskImageExistsWithKeyCompletion {
		@Generated
		void call_diskImageExistsWithKeyCompletion(boolean arg0);
	}

	@Generated
	@Selector("getDiskCount")
	@NUInt
	public native long getDiskCount();

	@Generated
	@Selector("getSize")
	@NUInt
	public native long getSize();

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("imageFromDiskCacheForKey:")
	public native UIImage imageFromDiskCacheForKey(String key);

	@Generated
	@Selector("imageFromMemoryCacheForKey:")
	public native UIImage imageFromMemoryCacheForKey(String key);

	@Generated
	@Selector("init")
	public native SDImageCache init();

	@Generated
	@Selector("initWithNamespace:")
	public native SDImageCache initWithNamespace(String ns);

	@Generated
	@Selector("initWithNamespace:diskCacheDirectory:")
	public native SDImageCache initWithNamespaceDiskCacheDirectory(String ns,
			String directory);

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
	@Selector("makeDiskCachePath:")
	public native String makeDiskCachePath(String fullNamespace);

	@Generated
	@Selector("maxCacheAge")
	@NInt
	public native long maxCacheAge();

	@Generated
	@Selector("maxCacheSize")
	@NUInt
	public native long maxCacheSize();

	@Generated
	@Selector("maxMemoryCost")
	@NUInt
	public native long maxMemoryCost();

	@Generated
	@Selector("maxMemoryCountLimit")
	@NUInt
	public native long maxMemoryCountLimit();

	@Generated
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("queryDiskCacheForKey:done:")
	public native NSOperation queryDiskCacheForKeyDone(
			String key,
			@ObjCBlock(name = "call_queryDiskCacheForKeyDone") Block_queryDiskCacheForKeyDone doneBlock);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_queryDiskCacheForKeyDone {
		@Generated
		void call_queryDiskCacheForKeyDone(UIImage arg0, @NInt long arg1);
	}

	@Generated
	@Selector("removeImageForKey:")
	public native void removeImageForKey(String key);

	@Generated
	@Selector("removeImageForKey:fromDisk:")
	public native void removeImageForKeyFromDisk(String key, boolean fromDisk);

	@Generated
	@Selector("removeImageForKey:fromDisk:withCompletion:")
	public native void removeImageForKeyFromDiskWithCompletion(
			String key,
			boolean fromDisk,
			@ObjCBlock(name = "call_removeImageForKeyFromDiskWithCompletion") Block_removeImageForKeyFromDiskWithCompletion completion);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_removeImageForKeyFromDiskWithCompletion {
		@Generated
		void call_removeImageForKeyFromDiskWithCompletion();
	}

	@Generated
	@Selector("removeImageForKey:withCompletion:")
	public native void removeImageForKeyWithCompletion(
			String key,
			@ObjCBlock(name = "call_removeImageForKeyWithCompletion") Block_removeImageForKeyWithCompletion completion);

	@Runtime(ObjCRuntime.class)
	@Generated
	public interface Block_removeImageForKeyWithCompletion {
		@Generated
		void call_removeImageForKeyWithCompletion();
	}

	@Generated
	@Selector("resolveClassMethod:")
	public static native boolean resolveClassMethod(SEL sel);

	@Generated
	@Selector("resolveInstanceMethod:")
	public static native boolean resolveInstanceMethod(SEL sel);

	@Generated
	@Selector("setMaxCacheAge:")
	public native void setMaxCacheAge(@NInt long value);

	@Generated
	@Selector("setMaxCacheSize:")
	public native void setMaxCacheSize(@NUInt long value);

	@Generated
	@Selector("setMaxMemoryCost:")
	public native void setMaxMemoryCost(@NUInt long value);

	@Generated
	@Selector("setMaxMemoryCountLimit:")
	public native void setMaxMemoryCountLimit(@NUInt long value);

	@Generated
	@Selector("setShouldCacheImagesInMemory:")
	public native void setShouldCacheImagesInMemory(boolean value);

	@Generated
	@Selector("setShouldDecompressImages:")
	public native void setShouldDecompressImages(boolean value);

	@Generated
	@Selector("setShouldDisableiCloud:")
	public native void setShouldDisableiCloud(boolean value);

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("sharedImageCache")
	public static native SDImageCache sharedImageCache();

	@Generated
	@Selector("shouldCacheImagesInMemory")
	public native boolean shouldCacheImagesInMemory();

	@Generated
	@Selector("shouldDecompressImages")
	public native boolean shouldDecompressImages();

	@Generated
	@Selector("shouldDisableiCloud")
	public native boolean shouldDisableiCloud();

	@Generated
	@Selector("storeImage:forKey:")
	public native void storeImageForKey(UIImage image, String key);

	@Generated
	@Selector("storeImage:forKey:toDisk:")
	public native void storeImageForKeyToDisk(UIImage image, String key,
			boolean toDisk);

	@Generated
	@Selector("storeImage:recalculateFromImage:imageData:forKey:toDisk:")
	public native void storeImageRecalculateFromImageImageDataForKeyToDisk(
			UIImage image, boolean recalculate, NSData imageData, String key,
			boolean toDisk);

	@Generated
	@Selector("storeImageDataToDisk:forKey:")
	public native void storeImageDataToDiskForKey(NSData imageData, String key);

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();
}