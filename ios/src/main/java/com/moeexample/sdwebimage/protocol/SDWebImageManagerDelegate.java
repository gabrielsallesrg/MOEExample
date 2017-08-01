package com.moeexample.sdwebimage.protocol;


import apple.foundation.NSURL;
import apple.uikit.UIImage;
import com.moeexample.sdwebimage.SDWebImageManager;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.IsOptional;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;

@Generated
@Library("SDWebImage")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("SDWebImageManagerDelegate")
public interface SDWebImageManagerDelegate {
	@Generated
	@IsOptional
	@Selector("imageManager:shouldDownloadImageForURL:")
	default boolean imageManagerShouldDownloadImageForURL(
			SDWebImageManager imageManager, NSURL imageURL) {
		throw new java.lang.UnsupportedOperationException();
	}

	@Generated
	@IsOptional
	@Selector("imageManager:transformDownloadedImage:withURL:")
	default UIImage imageManagerTransformDownloadedImageWithURL(
			SDWebImageManager imageManager, UIImage image, NSURL imageURL) {
		throw new java.lang.UnsupportedOperationException();
	}
}