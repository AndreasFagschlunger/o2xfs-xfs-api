package at.o2xfs.xfs.databind.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import at.o2xfs.memory.databind.annotation.MemoryAnnotationsInside;
import at.o2xfs.memory.databind.annotation.MemoryDeserialize;
import at.o2xfs.memory.databind.annotation.MemorySerialize;
import at.o2xfs.xfs.databind.deser.XfsEnumSet32Deserializer;
import at.o2xfs.xfs.databind.ser.XfsEnumSet32Serializer;

@Retention(RetentionPolicy.RUNTIME)
@MemoryAnnotationsInside
@MemorySerialize(using = XfsEnumSet32Serializer.class)
@MemoryDeserialize(using = XfsEnumSet32Deserializer.class)
public @interface XfsEnumSet32 {

	boolean zeroTerminated() default false;

}
