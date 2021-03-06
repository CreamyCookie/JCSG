package eu.mihosoft.vrl.v3d;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Objtest {

	@Test
	public void test() throws IOException {
		CSG hole = new Cylinder(0.2, 2).toCSG().movez(-1);
		CSG csg = new Cube (1).toCSG().difference(hole);
		csg.addDatumReference(new Transform());
		
		String s=csg.toObjString()
				.split("# Faces")[1]
				.split("# End")[0].trim();
		assertFalse(s.length()<4);		
		FileUtil.write(Paths.get("test.obj"),
				csg.toObjString());
//		csg.toObj().toFiles(Paths.get("test2.obj"));
	}

}
