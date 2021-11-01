package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Product;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class ApplianceDAOImpl implements ApplianceDAO {

	public static final String XML_ID_NAME = "id" ;
	private HashMap< String , Product >  map = null ;
	private ArrayList< Product >  overlap = null ;
	private List<Element> types = null ;

	public ApplianceDAOImpl( ) {
		map = new HashMap< String , Product >  () ;
	}

	public void find( ) {
		Scanner reader = new Scanner(System.in);
		overlap = new ArrayList< > ( ) ;
		Product product = null ;
		while  ( true ) {
			System.out.println( "input product parameter and value" ) ;
			String productParameterName = reader.nextLine( ).trim( ) ;
			String productParameterValue = reader.nextLine( ).trim( ) ;
			Set< String > set = getAllID( ) ;
			for  ( String key : set ) {
				product = get( key ) ;
				ArrayList< String > parametersName = product.getParametersName( ) ;
				Integer iterator = 0 ;
				while  ( iterator < parametersName.size( ) ) {
					if  ( Objects.equals( parametersName.get( iterator ) , productParameterName ) ) {
						if  ( Objects.equals( product.get( productParameterName ) , productParameterValue ) ) {
							overlap.add( product ) ;
						}
					}
					iterator++ ;
				}
			}
			if  ( overlap.size( ) > 0 )  break ;
			System.out.println( "matches not found" ) ;
		}
	}

	@Override
	public void load( String pathToFile ) {
		ApplianceDAO XMLParser = DAOFactory.getInstance().getApplianceDAO();
		try {
			File xmlFile = new File(pathToFile );
			SAXBuilder parser = new SAXBuilder();
			Document document = parser.build(xmlFile);
			Element root = document.getRootElement();
			types = root.getChildren();

			List<Element> ovens = types.get(0).getChildren();
			for (Element element : ovens) {
				Product object = new Product( element.getChildren( ).size( ) , element.getName( ) , element.getName( ) + element.getAttribute(XML_ID_NAME).getValue());

				List<Element> parameters = element.getChildren();
				object.set(SearchCriteria.Oven.POWER_CONSUMPTION.ordinal(),
						parameters.get(SearchCriteria.Oven.POWER_CONSUMPTION.ordinal() ).getName( ) ,
						parameters.get(SearchCriteria.Oven.POWER_CONSUMPTION.ordinal()).getText());
				object.set(SearchCriteria.Oven.WEIGHT.ordinal(),
						parameters.get(SearchCriteria.Oven.WEIGHT.ordinal()).getName(),
						parameters.get(SearchCriteria.Oven.WEIGHT.ordinal()).getText());
				object.set(SearchCriteria.Oven.CAPACITY.ordinal(),
						parameters.get(SearchCriteria.Oven.CAPACITY.ordinal()).getName(),
						parameters.get(SearchCriteria.Oven.CAPACITY.ordinal()).getText());
				object.set(SearchCriteria.Oven.DEPTH.ordinal(),
						parameters.get(SearchCriteria.Oven.DEPTH.ordinal()).getName(),
						parameters.get(SearchCriteria.Oven.DEPTH.ordinal()).getText());
				object.set(SearchCriteria.Oven.HEIGHT.ordinal(),
						parameters.get(SearchCriteria.Oven.HEIGHT.ordinal()).getName(),
						parameters.get(SearchCriteria.Oven.HEIGHT.ordinal()).getText());
				object.set(SearchCriteria.Oven.WIDTH.ordinal(),
						parameters.get(SearchCriteria.Oven.WIDTH.ordinal()).getName(),
						parameters.get(SearchCriteria.Oven.WIDTH.ordinal()).getText());

				XMLParser.set(object.getName(), object);
			}

			List<Element> laptops = types.get(1).getChildren();
			for (Element element : laptops) {
				Product object = new Product( element.getChildren( ).size( ) , element.getName( ) ,element.getName() + element.getAttribute(XML_ID_NAME).getValue());

				List<Element> parameters = element.getChildren();
				object.set(SearchCriteria.Laptop.BATTERY_CAPACITY.ordinal(),
						parameters.get(SearchCriteria.Laptop.BATTERY_CAPACITY.ordinal()).getName(),
						parameters.get(SearchCriteria.Laptop.BATTERY_CAPACITY.ordinal()).getText());
				object.set(SearchCriteria.Laptop.OS.ordinal(),
						parameters.get(SearchCriteria.Laptop.OS.ordinal()).getName(),
						parameters.get(SearchCriteria.Laptop.OS.ordinal()).getText());
				object.set(SearchCriteria.Laptop.MEMORY_ROM.ordinal(),
						parameters.get(SearchCriteria.Laptop.MEMORY_ROM.ordinal()).getName(),
						parameters.get(SearchCriteria.Laptop.MEMORY_ROM.ordinal()).getText());
				object.set(SearchCriteria.Laptop.SYSTEM_MEMORY.ordinal(),
						parameters.get(SearchCriteria.Laptop.SYSTEM_MEMORY.ordinal()).getName(),
						parameters.get(SearchCriteria.Laptop.SYSTEM_MEMORY.ordinal()).getText());
				object.set(SearchCriteria.Laptop.CPU.ordinal(),
						parameters.get(SearchCriteria.Laptop.CPU.ordinal()).getName(),
						parameters.get(SearchCriteria.Laptop.CPU.ordinal()).getText());
				object.set(SearchCriteria.Laptop.DISPLAY_INCHS.ordinal(),
						parameters.get(SearchCriteria.Laptop.DISPLAY_INCHS.ordinal()).getName(),
						parameters.get(SearchCriteria.Laptop.DISPLAY_INCHS.ordinal()).getText());

				XMLParser.set(object.getName(), object);
			}

			List<Element> refrigerators = types.get(2).getChildren();
			for (Element element : refrigerators) {
				Product object = new Product(  element.getChildren( ).size( ) , element.getName( ) ,element.getName() + element.getAttribute(XML_ID_NAME).getValue());

				List<Element> parameters = element.getChildren();
				object.set(SearchCriteria.Refrigerator.POWER_CONSUMPTION.ordinal(),
						parameters.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.ordinal()).getName(),
						parameters.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.ordinal()).getText());
				object.set(SearchCriteria.Refrigerator.WEIGHT.ordinal(),
						parameters.get(SearchCriteria.Refrigerator.WEIGHT.ordinal()).getName(),
						parameters.get(SearchCriteria.Refrigerator.WEIGHT.ordinal()).getText());
				object.set(SearchCriteria.Refrigerator.FREEZER_CAPACITY.ordinal(),
						parameters.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.ordinal()).getName(),
						parameters.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.ordinal()).getText());
				object.set(SearchCriteria.Refrigerator.OVERALL_CAPACITY.ordinal(),
						parameters.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.ordinal()).getName(),
						parameters.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.ordinal()).getText());
				object.set(SearchCriteria.Refrigerator.HEIGHT.ordinal(),
						parameters.get(SearchCriteria.Refrigerator.HEIGHT.ordinal()).getName(),
						parameters.get(SearchCriteria.Refrigerator.HEIGHT.ordinal()).getText());
				object.set(SearchCriteria.Refrigerator.WIDTH.ordinal(),
						parameters.get(SearchCriteria.Refrigerator.WIDTH.ordinal()).getName(),
						parameters.get(SearchCriteria.Refrigerator.WIDTH.ordinal()).getText());

				XMLParser.set(object.getName(), object);
			}

			List<Element> vacuumCleaners = types.get(3).getChildren();
			for (Element element : vacuumCleaners) {
				Product object = new Product( element.getChildren( ).size( ) , element.getName( ) , element.getName() + element.getAttribute(XML_ID_NAME).getValue());

				List<Element> parameters = element.getChildren();
				object.set(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.ordinal(),
						parameters.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.ordinal()).getName(),
						parameters.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.ordinal()).getText());
				object.set(SearchCriteria.VacuumCleaner.FILTER_TYPE.ordinal(),
						parameters.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.ordinal()).getName(),
						parameters.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.ordinal()).getText());
				object.set(SearchCriteria.VacuumCleaner.BAG_TYPE.ordinal(),
						parameters.get(SearchCriteria.VacuumCleaner.BAG_TYPE.ordinal()).getName(),
						parameters.get(SearchCriteria.VacuumCleaner.BAG_TYPE.ordinal()).getText());
				object.set(SearchCriteria.VacuumCleaner.WAND_TYPE.ordinal(),
						parameters.get(SearchCriteria.VacuumCleaner.WAND_TYPE.ordinal()).getName(),
						parameters.get(SearchCriteria.VacuumCleaner.WAND_TYPE.ordinal()).getText());
				object.set(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.ordinal(),
						parameters.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.ordinal()).getName(),
						parameters.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.ordinal()).getText());
				object.set(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.ordinal(),
						parameters.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.ordinal()).getName(),
						parameters.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.ordinal()).getText());

				XMLParser.set(object.getName(), object);
			}


			List<Element> tabletPCs = types.get(4).getChildren();
			for (Element element : tabletPCs) {
				Product object = new Product( element.getChildren( ).size( ) , element.getName( ) , element.getName() + element.getAttribute(XML_ID_NAME).getValue());

				List<Element> parameters = element.getChildren();
				object.set(SearchCriteria.TabletPC.BATTERY_CAPACITY.ordinal(),
						parameters.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.ordinal()).getName(),
						parameters.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.ordinal()).getText());
				object.set(SearchCriteria.TabletPC.DISPLAY_INCHES.ordinal(),
						parameters.get(SearchCriteria.TabletPC.DISPLAY_INCHES.ordinal()).getName(),
						parameters.get(SearchCriteria.TabletPC.DISPLAY_INCHES.ordinal()).getText());
				object.set(SearchCriteria.TabletPC.MEMORY_ROM.ordinal(),
						parameters.get(SearchCriteria.TabletPC.MEMORY_ROM.ordinal()).getName(),
						parameters.get(SearchCriteria.TabletPC.MEMORY_ROM.ordinal()).getText());
				object.set(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.ordinal(),
						parameters.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.ordinal()).getName(),
						parameters.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.ordinal()).getText());
				object.set(SearchCriteria.TabletPC.COLOR.ordinal(),
						parameters.get(SearchCriteria.TabletPC.COLOR.ordinal()).getName(),
						parameters.get(SearchCriteria.TabletPC.COLOR.ordinal()).getText());

				XMLParser.set(object.getName(), object);
			}

			List<Element> speakers = types.get(5).getChildren();
			for (Element element : speakers) {
				Product object = new Product( element.getChildren( ).size( ) , element.getName( ) , element.getName() + element.getAttribute(XML_ID_NAME).getValue());

				List<Element> parameters = element.getChildren();
				object.set(SearchCriteria.Speakers.POWER_CONSUMPTION.ordinal(),
						parameters.get(SearchCriteria.Speakers.POWER_CONSUMPTION.ordinal()).getName(),
						parameters.get(SearchCriteria.Speakers.POWER_CONSUMPTION.ordinal()).getText());
				object.set(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.ordinal(),
						parameters.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.ordinal()).getName(),
						parameters.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.ordinal()).getText());
				object.set(SearchCriteria.Speakers.FREQUENCY_RANGE.ordinal(),
						parameters.get(SearchCriteria.Speakers.FREQUENCY_RANGE.ordinal()).getName(),
						parameters.get(SearchCriteria.Speakers.FREQUENCY_RANGE.ordinal()).getText());
				object.set(SearchCriteria.Speakers.CORD_LENGTH.ordinal(),
						parameters.get(SearchCriteria.Speakers.CORD_LENGTH.ordinal()).getName(),
						parameters.get(SearchCriteria.Speakers.CORD_LENGTH.ordinal()).getText());

				XMLParser.set(object.getName(), object);
			}
		} catch (JDOMException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void save( String pathToFile ) {
		try {
			Document XML_output_document = new Document( ) ;
			XML_output_document.setRootElement( new Element( pathToFile ) ) ;
			for  ( Product founded : overlap ) {
				ArrayList< String >  list = founded.getAllParameters( ) ;
				Element template = null ;
				Element currentElement = new Element( founded.getType( ) ) ;
				Integer ID = Integer.parseInt( founded.getName( ).substring( founded.getType( ).length( ) , founded.getName( ).length( ) ) ) ;
				currentElement.setAttribute( XML_ID_NAME , ID.toString( ) ) ;
				for  ( Element element : types ) {
					if  ( Objects.equals( element.getName( ) , founded.getType( ) + "s" ) ) {
						List<Element> children = element.getChildren( ) ;
						for  ( Element child : children ) {
							if  ( child.getAttribute( XML_ID_NAME ).getIntValue( ) == ID ) {
								template = child ;
								break ;
							}
						}
						break ;
					}
				}

				Integer iterator = 0 ;
				while  ( iterator < template.getChildren( ).size( ) ) {
					Element parameter = new Element( template.getChildren( ).get( iterator ).getName( ) ) ;
					parameter.setText( list.get( iterator ) ) ;
					currentElement.addContent( parameter ) ;
					iterator++ ;
				}

				XML_output_document.getRootElement( ).addContent( currentElement ) ;
			}


			XMLOutputter output = new XMLOutputter( ) ;
			output.setFormat( Format.getPrettyFormat( ) ) ;
			output.output( XML_output_document , new FileWriter( pathToFile ) ) ;
		}
		catch (JDOMException | IOException exception) {
			exception.printStackTrace();
		}

	}

	@Override
	public void set( String ID , Product object )
	{
		if  ( map.containsKey( ID ) ) {
			map.put( ID , object ) ;
		} else {
			map.put( ID , object ) ;
		}
	}

	@Override
	public Set< String >  getAllID( ) {
		return map.keySet( ) ;
	}

	@Override
	public Product get( String ID ) {
		if  ( !map.containsKey( ID ) ) {
			return null ;
		}
		else {
			return map.get( ID ) ;
		}
	}
}
