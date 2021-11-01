package by.tc.task01.main;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory ;

public class PrintApplianceInfo {

	public static void main(String[] arguments) {

		ApplianceDAO XMLParser = DAOFactory.getInstance().getApplianceDAO();
		XMLParser.load( "applianced_db.xsd.xml" ) ;
		XMLParser.find( ) ;
		XMLParser.save( "save-data.xml" ) ;
	}
}

