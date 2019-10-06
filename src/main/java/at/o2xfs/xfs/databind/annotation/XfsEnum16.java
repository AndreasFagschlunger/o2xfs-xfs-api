package at.o2xfs.xfs.databind.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import at.o2xfs.memory.databind.annotation.MemoryAnnotationsInside;
import at.o2xfs.memory.databind.annotation.MemoryDeserialize;
import at.o2xfs.memory.databind.annotation.MemorySerialize;
import at.o2xfs.xfs.databind.deser.XfsEnum16Deserializer;
import at.o2xfs.xfs.databind.ser.XfsEnum16Serializer;

@Retention(RetentionPolicy.RUNTIME)
@MemoryAnnotationsInside
@MemorySerialize(using = XfsEnum16Serializer.class)
@MemoryDeserialize(using = XfsEnum16Deserializer.class)
public @interface XfsEnum16 {

}
