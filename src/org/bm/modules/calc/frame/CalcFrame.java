package org.bm.modules.calc.frame;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.bm.modules.shared.ModuleFrame;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;

public class CalcFrame extends ModuleFrame {
   private JFormattedTextField textField;

   private JTextField textFieldMem;

   private JButton b0;

   private JButton b1;

   private JButton b2;

   private JButton b3;

   private JButton b4;

   private JButton b5;

   private JButton b6;

   private JButton b7;

   private JButton b8;

   private JButton b9;

   private JButton bMC;

   private JButton bMR;

   private JButton bMS;

   private JButton bMPlus;

   private JButton bDiv;

   private JButton bMul;

   private JButton bSub;

   private JButton bAdd;

   private JButton bSqrt;

   private JButton bMod;

   private JButton bInv;

   private JButton bEquals;

   private JButton bMinus;

   private JButton bComma;

   private JButton bDel;

   private JButton bC;

   private JButton bCE;

   private final Stack<String> stack = new Stack<>();

   public CalcFrame() {
      this.setClosable(true);

      this.setIconifiable(false);
      this.setMaximizable(false);
      this.setResizable(false);

   }

   @Override
   public void initComponents() {
      super.initComponents();
      NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
      //numberFormat.setDecimalSeparatorAlwaysShown(true);
      textField = new JFormattedTextField(numberFormat);
      textField.setEditable(false);

      textField.setHorizontalAlignment(JTextField.RIGHT);
      textFieldMem = new JTextField();
      textFieldMem.setEditable(false);
      b0 = new JButton("0");
      setActionListener(b0);
      b1 = new JButton("1");
      setActionListener(b1);
      b2 = new JButton("2");
      setActionListener(b2);
      b3 = new JButton("3");
      setActionListener(b3);
      b4 = new JButton("4");
      setActionListener(b4);
      b5 = new JButton("5");
      setActionListener(b5);
      b6 = new JButton("6");
      setActionListener(b6);
      b7 = new JButton("7");
      setActionListener(b7);
      b8 = new JButton("8");
      setActionListener(b8);
      b9 = new JButton("9");
      setActionListener(b9);
      bMC = new JButton("MC");
      setActionListener(bMC);
      bMR = new JButton("MR");
      setActionListener(bMR);
      bMS = new JButton("MS");
      setActionListener(bMS);
      bMPlus = new JButton("M+");
      setActionListener(bMPlus);
      bDiv = new JButton("/");
      setActionListener(bDiv);
      bMul = new JButton("*");
      setActionListener(bMul);
      bSub = new JButton("-");
      setActionListener(bSub);
      bAdd = new JButton("+");
      setActionListener(bAdd);
      bSqrt = new JButton("Sqrt");
      setActionListener(bSqrt);
      bMod = new JButton("Mod");
      setActionListener(bMod);
      bInv = new JButton("Inv");
      setActionListener(bInv);
      bEquals = new JButton("=");
      setActionListener(bEquals);
      bMinus = new JButton("+/-");
      setActionListener(bMinus);
      bComma = new JButton(",");
      setActionListener(bComma);

      bDel = new JButton("Del");
      setActionListener(bDel);
      bCE = new JButton("CE");
      setActionListener(bCE);
      bC = new JButton("C");
      setActionListener(bC);

      FormLayout subLayout = new FormLayout("p, 3dlu, p, 3dlu, p", "p");
      PanelBuilder subPb = new PanelBuilder(subLayout);

      subPb.add(bDel, CC.xy(1, 1));
      subPb.add(bCE, CC.xy(3, 1));
      subPb.add(bC, CC.xy(5, 1));

      FormLayout layout = new FormLayout("p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p",
         "p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p, 3dlu, p");

      layout.setColumnGroups(new int[][] { { 1, 3, 5, 7, 9, 11 } });
      layout.setRowGroups(new int[][] { { 1, 3, 5, 7, 9, 11 } });

      PanelBuilder pb = new PanelBuilder(layout);
      pb.border(Borders.DIALOG);

      pb.add(textField, CC.xyw(1, 1, 11));

      pb.add(textFieldMem, CC.xy(1, 3));
      pb.add(subPb.build(), CC.xyw(3, 3, 9));

      pb.add(bMC, CC.xy(1, 5));
      pb.add(b7, CC.xy(3, 5));
      pb.add(b8, CC.xy(5, 5));
      pb.add(b9, CC.xy(7, 5));
      pb.add(bDiv, CC.xy(9, 5));
      pb.add(bSqrt, CC.xy(11, 5));

      pb.add(bMR, CC.xy(1, 7));
      pb.add(b4, CC.xy(3, 7));
      pb.add(b5, CC.xy(5, 7));
      pb.add(b6, CC.xy(7, 7));
      pb.add(bMul, CC.xy(9, 7));
      pb.add(bMod, CC.xy(11, 7));

      pb.add(bMS, CC.xy(1, 9));
      pb.add(b1, CC.xy(3, 9));
      pb.add(b2, CC.xy(5, 9));
      pb.add(b3, CC.xy(7, 9));
      pb.add(bSub, CC.xy(9, 9));
      pb.add(bInv, CC.xy(11, 9));

      pb.add(bMPlus, CC.xy(1, 11));
      pb.add(b0, CC.xy(3, 11));
      pb.add(bMinus, CC.xy(5, 11));
      pb.add(bComma, CC.xy(7, 11));
      pb.add(bAdd, CC.xy(9, 11));
      pb.add(bEquals, CC.xy(11, 11));
      this.setContentPane(pb.build());

      this.pack();
   }

   private void setActionListener(JButton b) {
      b.addActionListener(new ButtonActionListener(textField, textFieldMem, b.getText(), stack));

   }
}
