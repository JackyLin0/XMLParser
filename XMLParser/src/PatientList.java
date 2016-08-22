import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class PatientList {
	
	//建構子
	public void PatientList()
	{
		
	}
	
	
	public static void parse()
	{
		File fin=new File("PatientList.xml");
		
		try
		{
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance(); 
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse(fin);
			doc.getDocumentElement().normalize();
			NodeList nList=doc.getElementsByTagName("GROUP");
  			// 
			int numOfPeople=nList.item(0).getChildNodes().getLength();
			NodeList nodeList=nList.item(0).getChildNodes();
 			System.out.println(numOfPeople);
			System.out.println("================");
 			for(int i=0;i<numOfPeople;i++)
 			{
 				for (int j=0;j<nodeList.item(i).getAttributes().getLength();j++)
 				{
 					String s=nodeList.item(i).getAttributes().item(j).getTextContent();
 	 				System.out.println(s);  
  				}
 			
 			// 病歷資料	
 			NodeList myRecord=nodeList.item(i).getChildNodes();
 			int recordCount=myRecord.item(0).getAttributes().getLength();
 			for (int k=0;k<recordCount;k++)
 			{
	 			String s=myRecord.item(0).getAttributes().item(k).getTextContent();
	 			System.out.println(s);  			
 			} 
 			Element element=(Element) myRecord;
 			System.out.println(element.getElementsByTagName("BEDNO").item(0).getTextContent());
 			System.out.println(element.getElementsByTagName("NSID").item(0).getTextContent());
 			System.out.println(element.getElementsByTagName("CLINICALDATE").item(0).getTextContent());
 			System.out.println(element.getElementsByTagName("DISCHARGEDATE").item(0).getTextContent());
 			System.out.println(element.getElementsByTagName("MJDR1").item(0).getTextContent());
 			System.out.println(element.getElementsByTagName("MJDR2").item(0).getTextContent());
 			System.out.println(element.getElementsByTagName("MJDR3").item(0).getTextContent());
 			System.out.println(element.getElementsByTagName("CLINICALDOCUMENT").item(0).getTextContent());
 			System.out.println("================");


 		}
		
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
}
