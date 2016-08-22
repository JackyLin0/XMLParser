import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class DoctorList {	
	private static String[] department=new String[2];
	
	public void DoctorList()
	{}
	
	public static void parse()
	{
//		File file=new File("AccountList.xml");
		File file=new File("doctorList.xml");
		try
		{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document doc=builder.parse(file);
		doc.getDocumentElement().normalize();
		NodeList nList=doc.getElementsByTagName("GROUP");
		//利用 getAttributes(0).item(0)==>ID="802011"
		//   getAttributes(0).item(1)==>TEXT="會計一課"
		//   getAttributes(1).item(0).toString()==>ID="407030"
		//   getAttributes(1).item(0).toString()==> TEXT="門診收費課"
		int temp=nList.getLength();
		for (int i=0;i<temp;i++)
		{	
			NamedNodeMap attributes=nList.item(i).getAttributes();
			department[0]=  attributes.item(0).getTextContent().toString();
			department[1]= attributes.item(1).getTextContent().toString();

			// 算Child node的長度			
			int l=nList.item(i).getChildNodes().getLength();
			NodeList n=nList.item(i).getChildNodes();
			System.out.println(l);
			System.out.println(department[0]);
			System.out.println(department[1]);
			for(int j=0;j<l;j++)
			{
				String s=n.item(j).getAttributes().item(0).getTextContent();
				String s1=n.item(j).getAttributes().item(1).getTextContent();
				System.out.println(s);
				System.out.println(s1);
			}
		}	
//	 	
// 		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
