package at.o2xfs.xfs.databind.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import at.o2xfs.memory.databind.annotation.MemoryAnnotationsInside;
import at.o2xfs.memory.databind.annotation.MemoryDeserialize;
import at.o2xfs.memory.databind.annotation.MemorySerialize;
import at.o2xfs.xfs.databind.deser.XfsEnumSet16Deserializer;
import at.o2xfs.xfs.databind.ser.XfsEnumSet16Serializer;

@Retention(RetentionPolicy.RUNTIME)
@MemoryAnnotationsInside
@MemorySerialize(using = XfsEnumSet16Serializer.class)
@MemoryDeserialize(using = XfsEnumSet16Deserializer.class)
public @interface XfsEnumSet16 {

}
