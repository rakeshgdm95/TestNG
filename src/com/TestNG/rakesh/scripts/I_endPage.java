package com.TestNG.rakesh.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.TestNG.rakesh.supporters.PropertiesReusables;
import com.TestNG.rakesh.utilities.ApplVariables;
import com.TestNG.rakesh.utilities.LocMechValues;

public class I_endPage extends Ipartner {
	@Test
	public void iEndPage() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		PropertiesReusables prOr=ApplVariables.getOrObj(ApplVariables.getOrfilePath());
		click(prOr.getpropertyvalue("I_logootlnktxt"), LocMechValues.linkText);
	}
	

}
