package by.tc.task01.entity;

import java.util.*;

public class Product {

    public class Parameter {
        private Integer ID ;
        private String Type ;
        private String Value ;

        public Parameter( Integer parameterID , String parameterType , String value ) {
            this.ID = parameterID ;
            this.Type = parameterType ;
            this.Value = value ;
        }

        public Integer getID( ) {
            return this.ID ;
        }

        public String getType( ) {
            return this.Type ;
        }

        public String getValue( ) {
            return this.Value ;
        }
    }

    ArrayList< Parameter >  parameters ;
    private String name = "" ;
    private String productType = "" ;
    public Product( Integer sizeOfParameters , String productType , String name ) {
        this.productType = productType ;
        this.name = name ;
        parameters  = new ArrayList<> ( ) ;
        while  ( sizeOfParameters > 0 ) {
            parameters.add( null ) ;
            sizeOfParameters-- ;
        }
    }

    public String getName( ) {
        return this.name ;
    }

    public String getType( ) {
        return this.productType ;
    }

    public void set( Integer ID , String Type , String parameter ) {
        Parameter parameterField = new Parameter( ID , Type , parameter ) ;
        parameters.set( ID , parameterField ) ;
    }

    public String get( Integer ID ) {
        for  ( Parameter key : parameters ) {
            if  ( Objects.equals( key.getID( ) , ID ) ) {
                return parameters.get( ID ).getValue( ) ;
            }
        }
        return null ;
    }



    public String get( String type ) {
        for  ( Parameter key : parameters ) {
            if  ( Objects.equals( key.getType( ) , type ) ) {
                return key.getValue( ) ;
            }
        }
        return null ;
    }

    public ArrayList< String >  getParametersName( ) {
        ArrayList< String > names = new ArrayList< > ( ) ;
        Integer sizeOfMemory = parameters.size( ) ;
        while  ( sizeOfMemory > 0 ) {
            names.add( null ) ;
            sizeOfMemory-- ;
        }
        for  ( Parameter parameter : parameters ) {
            names.set( parameter.getID( ) , parameter.getType( ) ) ;
        }
        if  ( names.size( ) != 0 ) {
            return names ;
        }
        else {
            return null ;
        }
    }

    public ArrayList< String >  getAllParameters( ) {
        ArrayList< String >  list = new ArrayList< > (  ) ;
        Integer sizeOfMemory = parameters.size( ) ;
        while  ( sizeOfMemory > 0 ) {
            list.add( null ) ;
            sizeOfMemory-- ;
        }
        for ( Parameter parameter : parameters ) {
            list.set( parameter.getID( ) , parameter.getValue( ) ) ;
        }
        return list ;
    }
}
