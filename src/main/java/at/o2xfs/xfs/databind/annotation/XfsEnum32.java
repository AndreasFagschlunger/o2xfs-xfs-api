package at.o2xfs.xfs.databind.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import at.o2xfs.memory.databind.annotation.MemoryAnnotationsInside;
import at.o2xfs.memory.databind.annotation.MemoryDeserialize;
import at.o2xfs.memory.databind.annotation.MemorySerialize;
import at.o2xfs.xfs.databind.deser.XfsEnum32Deserializer;
import at.o2xfs.xfs.databind.ser.XfsEnum32Serializer;

@Retention(RetentionPolicy.RUNTIME)
@MemoryAnnotationsInside
@MemorySerialize(using = XfsEnum32Serializer.class)
@MemoryDeserialize(using = XfsEnum32Deserializer.class)
public @interface XfsEnum32 {

}
