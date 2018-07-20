package googleCodeJAM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class T9Spelling 
{
	public static void main(String... args) throws IOException
	{
		File file = new File("F:\\PROJECTS\\GOOGLE-CODE-JAM\\T9Spelling\\C-small-practice.in");
		File outFile = new File("F:\\PROJECTS\\GOOGLE-CODE-JAM\\T9Spelling\\C-small-practice.out");
		//File file = new File("F:\\PROJECTS\\GOOGLE-CODE-JAM\\T9Spelling\\C-large-practice.in");
		//File outFile = new File("F:\\PROJECTS\\GOOGLE-CODE-JAM\\T9Spelling\\C-large-practice.out");
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
		printDigitKeys(br, bw);
		br.close();
		bw.close();
	}

	private static void printDigitKeys(BufferedReader br,	BufferedWriter bw) throws IOException 
	{
		int numberOfTestCases=Integer.parseInt(br.readLine());
		System.out.println("Number of Test Cases : "+numberOfTestCases);
		int count=1;
		while (count<=numberOfTestCases) 
		{
			String inputString = br.readLine();
			String outputString = printDigits(inputString);
			System.out.println("Case #" + count +": Final Output : "+outputString+"\n");
			bw.write("Case #" + count +": "+ outputString+"\n");
			count++;
		}
	}


	private static String printDigits(String inputString) 
	{
		System.out.println("Input String : "+inputString);
		String outputString="";
		Map<String, String> letterComboMap  = new HashMap<>();
		letterComboMap.put("abc", "2");
		letterComboMap.put("def", "3");
		letterComboMap.put("ghi", "4");
		letterComboMap.put("jkl", "5");
		letterComboMap.put("mno", "6");
		letterComboMap.put("pqrs", "7");
		letterComboMap.put("tuv", "8");
		letterComboMap.put("wxyz", "9");
		boolean prevDigitSame=false;
		int prevDigit=0;
		char prevChar=0;
		String digit="";
		String PAUSE=" ";
		
		for(char letter:inputString.toCharArray())
		{
			if(letter==' ')
			{
				outputString = (letter==prevChar)?outputString+PAUSE+"0":outputString+"0";
				System.out.println("Letter is Space so Added 0 ..");
			}
			else
			{
				for(String combo:letterComboMap.keySet())
				{
					if(combo.indexOf(letter)!=-1)
					{
						System.out.println("Letter : "+letter);
						System.out.println("Combo : "+combo);
						int position = combo.indexOf(letter)+1;
						System.out.println("Position : "+position);
						digit=letterComboMap.get(combo);
						System.out.println("Digit : "+digit);
						System.out.println("Pressed Key"+digit+" "+position+ " times.");
						prevDigitSame = (prevDigit==Integer.parseInt(digit))?true:false;
						outputString += pressDigits(digit,position,prevDigitSame);
						System.out.println("Output so far : "+outputString);
					}
				}
			}
			if(!"".equals(digit))
			{
			  prevDigit=Integer.parseInt(digit);
			}
			prevChar=letter;
			
		}

		return outputString;

	}

	private static String pressDigits(String digit, int position, boolean prevDigitSame)
	{
		String outputString="";
		for(int i=1;i<=position;i++)
		{
			outputString+=digit;
		}
		if(prevDigitSame==true)
		{
			System.out.println("Previous Pressed Key is same..So pausing...");
		}
		outputString = (prevDigitSame==true)?" "+outputString:outputString;

		return outputString;
	}
 
}
