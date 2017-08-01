package com.moeexample.sdwebimage.c;


import apple.uikit.UIImage;
import org.moe.natj.c.CRuntime;
import org.moe.natj.c.ann.CFunction;
import org.moe.natj.c.ann.CVariable;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.MappedReturn;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.map.ObjCStringMapper;

@Generated
@Library("SDWebImage")
@Runtime(CRuntime.class)
public final class SDWebImage {
	static {
		NatJ.register();
	}

	@Generated
	private SDWebImage() {
	}

	@Generated
	@CFunction
	public static native UIImage SDScaledImageForKey(
			@Mapped(ObjCStringMapper.class) String key, UIImage image);

	@Generated
	@CVariable()
	@MappedReturn(ObjCStringMapper.class)
	public static native String SDWebImageErrorDomain();

	@Generated
	@CVariable()
	@MappedReturn(ObjCStringMapper.class)
	public static native String SDWebImageDownloadStartNotification();

	@Generated
	@CVariable()
	@MappedReturn(ObjCStringMapper.class)
	public static native String SDWebImageDownloadStopNotification();
}