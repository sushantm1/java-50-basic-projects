package currency_pkg;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import javax.naming.InitialContext;
import javax.swing.JButton;
//import javax.naming.directory.SearchControls;
//import javax.naming.directory.SearchResult;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Currency_conv_main {
		public static void main(String[] args) {
			
			 
			//frame
			JFrame frame=new JFrame();
			frame.setSize(550,350);
			frame.setTitle("Currency-Converter");
			frame.setLayout(null);
			
			
			//amount label
			JLabel amtlbl=new JLabel("Amount : ");
			amtlbl.setFont(new Font("Arial", Font.BOLD, 18));
			amtlbl.setSize(150, 30);
			amtlbl.setLocation(20, 15);
			frame.add(amtlbl);
			
			//amount text field
			JTextField amttxtfeild =new JTextField();
			amttxtfeild.setFont(new Font("Arial", Font.PLAIN, 17));
			amttxtfeild.setSize(150, 30);
			amttxtfeild.setLocation(200, 15);
			frame.add(amttxtfeild);
			
			//from curr label
			JLabel frmcutlbl=new JLabel("From Currency : ");
			frmcutlbl.setFont(new Font("Arial", Font.BOLD, 18));
			frmcutlbl.setSize(150, 30);
			frmcutlbl.setLocation(20,55);
			frame.add(frmcutlbl);
			
			//j combo box
//			JComboBox<E> 
			
			//to currency label
			JLabel tocurrlbl=new JLabel("To Currency : ");
			tocurrlbl.setFont(new Font("Arial", Font.BOLD, 18));
			tocurrlbl.setSize(200, 30);
			tocurrlbl.setLocation(20,95);
			frame.add(tocurrlbl);
			
			
			
			//country list
//			List<String> countrylist=new ArrayList<String>();
//			countrylist.add("Nepalese Rupee (NPR)");
//			countrylist.add("Bhutanese Ngultrum (BTN)");
//			countrylist.add("Bangladeshi Taka (BDT)");
			
			String[] country_currency= { 
					"Indian Rupee (INR)",
					"Australian Dollar (AUD)",
				    "Brazilian Real (BRL)",
				    "British Pound Sterling (GBP)",
				    "Canadian Dollar (CAD)",
				    "Chinese Yuan (CNY)",
				    "Euro (EUR)",
				    "Japanese Yen (JPY)",
				    "Swiss Franc (CHF)",
				    "United States Dollar (USD)"
			};
			
//			HashMap<String,Double> countryCurrency = new HashMap<>();
//
//	        countryCurrency.put("Indian Rupee", 0.012);
//	        countryCurrency.put("Australian Dollar",0.64);
//	        countryCurrency.put("Brazilian Real", 0.19);
//	        countryCurrency.put("British Pound Sterling", 1.22);
//	        countryCurrency.put("Canadian Dollar",0.73);
//	        countryCurrency.put("Chinese Yuan",0.14);
//	        countryCurrency.put("Euro",1.05);
//	        countryCurrency.put("Japanese Yen",0.0067);
//	        countryCurrency.put("Swiss Franc",1.10);
//	        countryCurrency.put("United States Dollar",1.00);

	       
	        
			//j combo box for from currency
			@SuppressWarnings("unchecked")
			JComboBox frm_curr_cb=new JComboBox(country_currency);
			frm_curr_cb.setFont(new Font("Arial", Font.PLAIN, 17));
//			frm_curr_cb.setEditable(true);
//			frm_curr_cb.addActionListener(frm_curr_cb);
//			frm_curr_cb.getItemAt(1).equals("SearchResult");
			frm_curr_cb.setSize(250, 30);
			frm_curr_cb.setLocation(200,55);
			frame.add(frm_curr_cb);
			
			// jcmobo box for to currency
			JComboBox to_curr_cb= new JComboBox(country_currency);
			to_curr_cb.setFont(new Font("Arial", Font.PLAIN, 17));
//			to_curr_cb.setEditable(true);
//			to_curr_cb.addActionListener(to_curr_cb);
//			to_curr_cb.getItemAt(1).equals("SearchResult");
			to_curr_cb.setSize(250, 30);
			to_curr_cb.setLocation(200,95);
			frame.add(to_curr_cb);
			
			//label for amount converted
			JLabel amtconvlbl=new JLabel("Amount Converted : ");
			amtconvlbl.setFont(new Font("Arial", Font.BOLD, 18));
			amtconvlbl.setSize(150, 30);
			amtconvlbl.setLocation(20,135);
			frame.add(amtconvlbl);
			
			//converted amount field
			JTextField conv_amt_txtfeild =new JTextField();
			conv_amt_txtfeild.setSize(150, 30);
			conv_amt_txtfeild.setLocation(200, 135);
			frame.add(conv_amt_txtfeild);
			
			
			
		       		
			//convert button 
			JButton conv_button =new JButton("CONVERT");
			conv_button.setFont(new Font("Arial", Font.BOLD, 18));
			conv_button.setSize(150, 35);
			conv_button.setLocation(45, 185);
			frame.add(conv_button);
			conv_button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
//					double[] usd_val= new double[1];
//					usd_val[0]=1.00;
//						       
//				    double[] final_conv_val= new double[1];
//				    final_conv_val[0]=1.00; 
					AtomicReference<Double> usd_val = new AtomicReference<>(1.00);
	                AtomicReference<Double> final_conv_val = new AtomicReference<>(1.00);

					//switch for updating the value of the from which we WANT TO CONVERT 
					switch ((String)frm_curr_cb.getSelectedItem()) {
					case "Indian Rupee (INR)":
                        usd_val.set(usd_val.get() * 0.012);
                        break;
                    case "Australian Dollar (AUD)":
                        usd_val.set(0.67);
                        break;
                    case "Brazilian Real (BRL)":
                        usd_val.set(usd_val.get() * 0.19);
                        break;
                    case "British Pound Sterling (GBP)":
                        usd_val.set(usd_val.get() * 1.22);
                        break;
                    case "Canadian Dollar (CAD)":
                        usd_val.set(usd_val.get() * 0.73);
                        break;
                    case "Chinese Yuan (CNY)":
                        usd_val.set(usd_val.get() * 0.14);
                        break;
                    case "Euro (EUR)":
                        usd_val.set(usd_val.get() * 1.05);
                        break;
                    case "Japanese Yen (JPY)":
                        usd_val.set(usd_val.get() * 0.0067);
                        break;
                    case "Swiss Franc (CHF)":
                        usd_val.set(usd_val.get() * 1.10);
                        break;
                    case "United States Dollar (USD)":
                        usd_val.set(usd_val.get() * 1.00);
                        break;
                    default:
//		                throw new IllegalArgumentException("Currency not found");
		        }
					
					//switch for updating the value of the TO which we WANT TO CONVERT  
					   switch ((String)to_curr_cb.getSelectedItem()) {
					   case "Indian Rupee (INR)":
	                        final_conv_val.set(0.012);
	                        break;
	                    case "Australian Dollar (AUD)":
	                        final_conv_val.set(0.67);
	                        break;
	                    case "Brazilian Real (BRL)":
	                        final_conv_val.set(0.19);
	                        break;
	                    case "British Pound Sterling (GBP)":
	                        final_conv_val.set(1.22);
	                        break;
	                    case "Canadian Dollar (CAD)":
	                        final_conv_val.set(0.73);
	                        break;
	                    case "Chinese Yuan (CNY)":
	                        final_conv_val.set(0.14);
	                        break;
	                    case "Euro (EUR)":
	                        final_conv_val.set(1.05);
	                        break;
	                    case "Japanese Yen (JPY)":
	                        final_conv_val.set(0.0067);
	                        break;
	                    case "Swiss Franc (CHF)":
	                        final_conv_val.set(1.10);
	                        break;
	                    case "United States Dollar (USD)":
	                        final_conv_val.set(1.00);
	                        break;
	                    default:
//			                throw new IllegalArgumentException("Currency not found");
			        }	
					Double intial_val= Double.valueOf(amttxtfeild.getText()); // got value from amount text field. 
					double last=usd_val.get(); //converted to usd
					
					double x = intial_val *last / final_conv_val.get();
					conv_amt_txtfeild.setText(String.valueOf(x));


					System.out.println(intial_val);
					System.out.println(usd_val.get());
//					System.out.println(last);
					System.out.println(final_conv_val.get());
					System.out.println(x);
//					System.out.println(); 
					
				}
			});
			//convert button 
			JButton reset_button =new JButton("RESET");
			reset_button.setFont(new Font("Arial", Font.BOLD, 18));
			reset_button.setSize(150, 35);
			reset_button.setLocation(250, 185);
			frame.add(reset_button);
			reset_button.addActionListener(new ActionListener() 
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					// TODO Auto-generated method stub
					amttxtfeild.setText("");
					conv_amt_txtfeild.setText("");
				}
			}
			);

			//exit
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
}
