package com.moeexample.sdwebimage.protocol;


import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;

@Generated
@Library("SDWebImage")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("SDWebImageOperation")
public interface SDWebImageOperation {
	@Generated
	@Selector("cancel")
	void cancel();
}