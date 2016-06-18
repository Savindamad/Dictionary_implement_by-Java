import java.awt.*;
import java.io.*;
import java.util.*; 
import javax.swing.*;
import java.awt.event.*;

class dic extends JFrame implements ActionListener{
	
	//create java frame
	private JFrame dicGUI = new JFrame("Dictionary");

	//create all buttons, labels, buttons
	//intialize buttons
	private final JButton searchDefBtn = new JButton("Search");  
	private final JButton searchSimBtn = new JButton("similar words");
	private final JButton deleteBtn = new JButton("Delete");
	private final JButton clearBtn = new JButton("Clear");
	private final JButton clearAddNewBtn = new JButton("Clear");
	private final JButton addBtn = new JButton("Add");
	
	//intialize labels
	private final JLabel headding1 = new JLabel("My dictionary");
	private final JLabel headding2 = new JLabel("Add new word");
	private JLabel checkSuccess = new JLabel("");
	
	//intialize text fields
	private JTextField wordName = new HintTextField("Enter word");
	private JTextField wordNameAdd = new HintTextField("Enter word");
	private JTextField wordDefAdd = new HintTextField("Enter definition");
	private JTextField wordSimAdd = new HintTextField("Enter similar words");
	
	// initialize text area
	private JTextArea definitionAreaText = new JTextArea();

	//initialize panel
	private JPanel dicPanel = new JPanel();
	private JPanel addNewWordPanel = new JPanel();
	
	//create binary search tree
	BinarySearchTree dictionary = new BinarySearchTree();

	dic(){
		this.insertData(); //insert data into binary search tree
		this.createGUI(); //create java GUI
	}

	private void createGUI(){
		//java frame
		dicGUI.getContentPane().setBackground(Color.LIGHT_GRAY); 

		//add action listener to all buttons
		searchDefBtn.addActionListener(this);
		searchSimBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		clearAddNewBtn.addActionListener(this);
		addBtn.addActionListener(this);

		//set preferred size 
		//set sizes of labels
		headding1.setPreferredSize(new java.awt.Dimension(220, 30));
		headding1.setPreferredSize(new java.awt.Dimension(220, 30));
		//set sizes of text fields
		wordName.setPreferredSize(new java.awt.Dimension(220, 30));
		wordNameAdd.setPreferredSize(new java.awt.Dimension(230, 30));
		wordDefAdd.setPreferredSize(new java.awt.Dimension(230, 30));
		wordSimAdd.setPreferredSize(new java.awt.Dimension(230, 30));
		//set sizes of text area
		
        definitionAreaText.setPreferredSize(new java.awt.Dimension(220, 100));
        definitionAreaText.setLineWrap(true);
		//set sizes of buttons
		searchDefBtn.setPreferredSize(new java.awt.Dimension(120, 30));
		searchDefBtn.setBackground(Color.DARK_GRAY);
		searchDefBtn.setForeground(Color.WHITE);

		searchSimBtn.setPreferredSize(new java.awt.Dimension(120, 30));
        searchSimBtn.setBackground(Color.DARK_GRAY);
        searchSimBtn.setForeground(Color.WHITE);

		deleteBtn.setPreferredSize(new java.awt.Dimension(120, 30));
        deleteBtn.setBackground(Color.DARK_GRAY);
        deleteBtn.setForeground(Color.WHITE);

		clearBtn.setPreferredSize(new java.awt.Dimension(120, 30));
        clearBtn.setBackground(Color.DARK_GRAY);
        clearBtn.setForeground(Color.WHITE);

		addBtn.setPreferredSize(new java.awt.Dimension(110, 70));
        addBtn.setBackground(Color.DARK_GRAY);
        addBtn.setForeground(Color.WHITE);

		clearAddNewBtn.setPreferredSize(new java.awt.Dimension(110, 30));
        clearAddNewBtn.setBackground(Color.DARK_GRAY);
        clearAddNewBtn.setForeground(Color.WHITE);

		//set sizes of panels
		dicPanel.setPreferredSize(new java.awt.Dimension(370, 200));
		addNewWordPanel.setPreferredSize(new java.awt.Dimension(370, 160));
		dicPanel.setBackground(Color.GRAY);
		addNewWordPanel.setBackground(Color.GRAY);

		//create panel 1
		javax.swing.GroupLayout dicPanelLayout = new javax.swing.GroupLayout(dicPanel);
        dicPanel.setLayout(dicPanelLayout);
        dicPanelLayout.setHorizontalGroup(dicPanelLayout.createParallelGroup()
            .addGroup(dicPanelLayout.createSequentialGroup()
            	.addGap(10,10,10)
                .addGroup(dicPanelLayout.createParallelGroup()
                    .addComponent(headding1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10,10,10)
                    .addGroup(dicPanelLayout.createSequentialGroup()
                        .addGroup(dicPanelLayout.createParallelGroup()
                        	.addComponent(wordName,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(definitionAreaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            )
                        .addGap(10,10,10)
                        .addGroup(dicPanelLayout.createParallelGroup()
                            .addComponent(searchDefBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchSimBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                    )
                )
            )
        );
        dicPanelLayout.setVerticalGroup(
            dicPanelLayout.createParallelGroup()
            .addGroup(dicPanelLayout.createSequentialGroup()
                .addGap(10,10,10)
                .addComponent(headding1)
                .addGap(10,10,10)
                .addGroup(dicPanelLayout.createParallelGroup()
                    .addComponent(wordName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchDefBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    )
                .addGap(10,10,10)
                .addGroup(dicPanelLayout.createParallelGroup()
                	.addComponent(definitionAreaText,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dicPanelLayout.createSequentialGroup()
                        .addComponent(searchSimBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    )
                )
            )
        );
        //create panel 2
        javax.swing.GroupLayout addNewWordPanelLayout = new javax.swing.GroupLayout(addNewWordPanel);
        addNewWordPanel.setLayout(addNewWordPanelLayout);
        addNewWordPanelLayout.setHorizontalGroup(addNewWordPanelLayout.createParallelGroup()
        	.addGroup(addNewWordPanelLayout.createSequentialGroup()
        	.addGap(10,10,10)
        	.addGroup(addNewWordPanelLayout.createParallelGroup()
        		.addComponent(headding2)
        		.addGroup(addNewWordPanelLayout.createSequentialGroup()
        			.addComponent(wordNameAdd,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        			.addGap(10,10,10)
        			.addComponent(clearAddNewBtn,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        		)
        		.addGroup(addNewWordPanelLayout.createSequentialGroup()
        			
        			.addGroup(addNewWordPanelLayout.createParallelGroup()
        				.addComponent(wordDefAdd,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        				.addComponent(wordSimAdd,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        			)
        			.addGap(10,10,10)
        			.addComponent(addBtn,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        		)
        	)
        	)
        );
        addNewWordPanelLayout.setVerticalGroup(addNewWordPanelLayout.createSequentialGroup()
        	.addGroup(addNewWordPanelLayout.createSequentialGroup()
        		.addGap(10,10,10)
        		.addComponent(headding2)
        		.addGap(10,10,10)
        		.addGroup(addNewWordPanelLayout.createParallelGroup()
        			.addComponent(wordNameAdd,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        			.addComponent(clearAddNewBtn,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        		)
        		.addGap(10,10,10)
        		.addGroup(addNewWordPanelLayout.createParallelGroup()
        			.addGroup(addNewWordPanelLayout.createSequentialGroup()
        				.addComponent(wordDefAdd,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        				.addGap(10,10,10)
        				.addComponent(wordSimAdd,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        			)
        			.addComponent(addBtn,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          		)
          	)
        );

        //set panels ot the frame
        javax.swing.GroupLayout dicLayout = new javax.swing.GroupLayout(dicGUI.getContentPane());
        dicGUI.getContentPane().setLayout(dicLayout);
        dicLayout.setHorizontalGroup(dicLayout.createParallelGroup()
        	.addGroup(dicLayout.createSequentialGroup()
        		.addGap(10,10,10)
            	.addGroup(dicLayout.createParallelGroup()
            		.addGap(10,10,10)
                	.addComponent(dicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                	.addComponent(addNewWordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                	.addGap(10,10,10)
                )
                .addGap(10,10,10)
            )
        );
        dicLayout.setVerticalGroup(dicLayout.createSequentialGroup()
            .addGroup(dicLayout.createSequentialGroup()
            .addGap(10,10,10)
                .addComponent(dicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10,10,10)
                .addComponent(addNewWordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10,10,10))
        );

        dicGUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //set close operator
        dicGUI.setLayout(dicLayout);								 //set layout
        dicGUI.pack();
        dicGUI.setLocationRelativeTo(null);
        dicGUI.setVisible(true);        							 //visible layout

        //set listener when click the close button
        dicGUI.addWindowListener(new java.awt.event.WindowAdapter() {
    		@Override
    		public void windowClosing(java.awt.event.WindowEvent windowEvent) {
    			update();
            	System.exit(0);
        
    		}
		});

	}

	//insert data into binary search tree
	private void insertData(){
		try{
            FileReader reader = new FileReader("input.txt");        		//read dictionary text file      
            BufferedReader bufferedReader = new BufferedReader(reader);		//buffer reader
			String str1 = null; String str2 = null; 						//intialize str1 and str2 as null

			//read input line by line
            while( (str1=bufferedReader.readLine()) != null ){
				int arraySize = 0;
				int count = 0;
				
				String words[];        		//create string array to add similar words
				StringTokenizer s1,s2; 		//create String tokenizer to tokenize string

 				s1=new StringTokenizer(str1,",");		//tokenize string by ','

				String word = s1.nextToken();
				String definition = s1.nextToken();
                String similar="";
                if(s1.hasMoreTokens()){
                    similar = s1.nextToken();
                }
				

				for(int i = 0; i<similar.length(); i++){   //count number of similar words
					if(similar.charAt(i)==' '){
						count++;
					}
				}
				words = new String[count+1];			//initialize the size of array according to number of similar words
				
				s2=new StringTokenizer(similar," ");	//tokenize similar words. tokenize string by space
				
				while (s2.hasMoreTokens()) 				//add similar words to the array
				{		
					str2 = s2.nextToken();
					words[arraySize++]=str2;
				}
				//get hash value of word
				double hashval = hashfunc(word);       //get hash value of word
				dictionary.insert(hashval,word,definition,words,arraySize);  //insert data into the binary search tree
            }
			bufferedReader.close();
			reader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
	}

	//hash function to get hash value of word
	private static double hashfunc(String word){
		String hashval = "";
		for(int i = 0; i<word.length();i++){
			char c = word.charAt(i);
			if((int)c>96){
				hashval+=""+((int)c - 96);
			}
			else{
				hashval+=""+((int)c - 64);
			}
		}
		hashval+=word.length();
		return Double.parseDouble(hashval);
	}

	//Search definition of given word
	private String findDefinition(String word){
		return dictionary.findDef(hashfunc(word));
	}

	//Seach similar words of given word
	private String[] findSimilarWords(String word){
		return dictionary.findSimilar(hashfunc(word));
	}

	//delete word
	private boolean delete(String word){
		if(dictionary.delete(hashfunc(word))){
			return true;
		}
		else{
			return false;
		}
		
	}

	//update input text file
	public void update(){
		dictionary.writeData();
	}
	private void msgbox(String message, String title, String type){
		if(type.equals("Error")){
   			JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
   		}
   		else if(type.equals("Information")){
   			JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
   		}
   		else if(type.equals("Warning")){
   			JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
   		}
	}

	//action listner
	public void actionPerformed(ActionEvent e){
        if (e.getSource() == searchDefBtn) {    //if click Searchdef button 
            String word = wordName.getText();   //get text from text field
            if(word.equals("") || word.equals("Enter word")){ 					//if word equals null, show msg from msg box
            	msgbox("You did not enter any word","Enter the word","Error");
            }
            else{
            	String wordDef = this.findDefinition(word); //get definition of given word
            	if(wordDef=="null"){
            		msgbox("Word not found in dictionary","Not found","Information"); //
            	}
            	else{
            		definitionAreaText.setText(wordDef); //print definition in text area
            	}
            }
        }
        //Search simalar words
        else if(e.getSource() == searchSimBtn){
        	String word = wordName.getText();   //get text from text field
            if(word.equals("") || word.equals("Enter word")){
            	msgbox("You did not enter any word","Enter the word","Error");
            }
            else{
            	String wordSim[] = this.findSimilarWords(word); //get definition of given word
            	if(wordSim==null){
            		msgbox("Word not found in dictionary","Not found","Information"); 
            	}
                else if(wordSim[0]==null){
                    msgbox("Similar word not found in dictionary","No similar words","Information");
                }
            	else{
            		int arrySize = wordSim.length;
            		String simlarWords="";
            		for(int i = 0; i<arrySize;i++){           // arrange simliar word
            			simlarWords += wordSim[i] + "\n";
            		}
            		definitionAreaText.setText(simlarWords); //print simlar words in text area
            	}
            }
        }
        //delete word
        else if(e.getSource() == deleteBtn){
        	String word = wordName.getText();   //get text from text field
            if(word == null){
            	msgbox("You did not enter any word","Enter the word","Error");
            }
            else{
            	boolean status = this.delete(word); //get definition of given word
            	if(status){
            		msgbox("deleted successfully","Deleted","Information"); 
            	}
            	else{
            		msgbox("Word not found in dictionary","Not found","Information"); 
            	}
            }
        }
        else if(e.getSource() == clearBtn){
        	wordName.setText("");
        	definitionAreaText.setText("");
        }

        else if(e.getSource() == clearAddNewBtn){
        	wordNameAdd.setText("");
        	wordDefAdd.setText("");
        	wordSimAdd.setText("");

        }
        else if(e.getSource() == addBtn){
        	int count = 0;
        	String getword = wordNameAdd.getText();
        	String getdef =	wordDefAdd.getText();
        	String getsim = wordSimAdd.getText();
        	String[] similarWords;
        	StringTokenizer s3 = new StringTokenizer(getsim, " ");

        	for(int i = 0; i<getsim.length(); i++){
					if(getsim.charAt(i)==' '){
						count++;
					}
			}
			similarWords = new String[count+1];
			count = 0;
        	while(s3.hasMoreTokens()){		
					similarWords[count++]=s3.nextToken();
				}

        	if(getword== "" || getdef == "" || getword == "Enter word" || getdef == "Enter definition"){
        		msgbox("You did not enter any word","Enter the word","Error");
        	}
        	else{
        		if(dictionary.insert(hashfunc(getword),getword,getdef,similarWords,count)){
        			msgbox("Word added successfully","Success","Information"); 
        		}
        		else{
        			msgbox("Word already in the dictionary","Success","Warning");
        		}
        		wordNameAdd.setText("");
        		wordDefAdd.setText("");
        		wordSimAdd.setText("");
        	}
        	
        }
    }

    //main methord
	public static void main(String arg[]){
		//create new dic class
		dic d = new dic();
	}
}

//implement class to show hits 
class HintTextField extends JTextField implements FocusListener {

  private final String hint;
  private boolean showingHint;

  public HintTextField(final String hint) {
    super(hint);
    this.hint = hint;
    this.showingHint = true;
    super.addFocusListener(this);
  }

  @Override
  public void focusGained(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText("");
      showingHint = false;
    }
  }
  @Override
  public void focusLost(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText(hint);
      showingHint = true;
    }
  }

  @Override
  public String getText() {
    return showingHint ? "" : super.getText();
  }
}
