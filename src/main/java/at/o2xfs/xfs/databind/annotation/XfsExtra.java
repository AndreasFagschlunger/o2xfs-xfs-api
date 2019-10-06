package at.o2xfs.xfs.databind.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import at.o2xfs.memory.databind.annotation.MemoryAnnotationsInside;
import at.o2xfs.memory.databind.annotation.MemoryDeserialize;
import at.o2xfs.memory.databind.annotation.MemorySerialize;
import at.o2xfs.memory.databind.annotation.Pointer;
import at.o2xfs.xfs.databind.deser.XfsMultiByteMapDeserializer;
import at.o2xfs.xfs.databind.ser.XfsMultiByteMapSerializer;

@Retention(RetentionPolicy.RUNTIME)
@MemoryAnnotationsInside
@Pointer
@MemorySerialize(using = XfsMultiByteMapSerializer.class)
@MemoryDeserialize(using = XfsMultiByteMapDeserializer.class)
public @interface XfsExtra {

}
