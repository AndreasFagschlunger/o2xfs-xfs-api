package at.o2xfs.xfs.databind.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import at.o2xfs.memory.databind.annotation.MemoryAnnotationsInside;
import at.o2xfs.memory.databind.annotation.MemoryDeserialize;
import at.o2xfs.memory.databind.annotation.MemorySerialize;
import at.o2xfs.xfs.databind.deser.GuidLightsDeserializer;
import at.o2xfs.xfs.databind.ser.GuidLightsSerializer;

@Retention(RetentionPolicy.RUNTIME)
@MemoryAnnotationsInside
@MemorySerialize(using = GuidLightsSerializer.class)
@MemoryDeserialize(using = GuidLightsDeserializer.class)
public @interface XfsGuidLights {

	public int length();

}
