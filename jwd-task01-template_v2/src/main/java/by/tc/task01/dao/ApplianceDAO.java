package by.tc.task01.dao;

import by.tc.task01.entity.Product;
import java.util.HashMap;
import java.util.Set;

public interface ApplianceDAO {
	HashMap< String , Product > map = null ;

	void find( ) ;

	void load( String pathToFile ) ;

	void save( String pathToFile ) ;

	void set( String ID , Product object ) ;

	Product get( String ID ) ;

	Set< String > getAllID( ) ;
}
