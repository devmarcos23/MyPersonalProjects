
package jogoVelha;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author @GitHub: devmarcos23
 */
public class BlueHash extends javax.swing.JFrame {
    
    private boolean decisao;
    private Random sortear = new Random();
    private String listaResultado[][] = new String[3][3];
    private int resultadoSorteio = 0;
    private int numeroDejogadas = 0;
    
    public BlueHash() {
        initComponents();
        
        pnlDeExibicao.setVisible(true);
        
        pnlMain.setVisible(true);
        pnlMain.setOpaque(false);
        pnlLabelsMain.setVisible(false);
        pnlLabelsMain.setOpaque(false);
        pnlLabelsResultado.setVisible(false);
        pnlLabelsResultado.setOpaque(false);
        lblAvisoPnlMain.setVisible(false);
        
        pnlSecond.setVisible(true);
        pnlSecond.setOpaque(false);
        lblAvisoPnlSecond.setVisible(false);
        lblResultadoSorteio.setVisible(false);
        
        pnlThird.setVisible(false);
        pnlThird.setOpaque(false);
        
        setDecisao(false);
    }

    
    
    //criar gradiente de cor do painel de exibição
    class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            // Definir as cores do gradiente
            Color color1 = new Color(0x000428);
            Color color2 = new Color(0x004e92);

            // Criar o gradiente vertical
            GradientPaint gradient = new GradientPaint(0, 0, color1, 0, getHeight(), color2);

            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
    public boolean isDecisao() {
        return decisao;
    }

    public void setDecisao(boolean decisao) {
        this.decisao = decisao;
    }

    public int getResultadoSorteio() {
        return resultadoSorteio;
    }

    public void setResultadoSorteio(int resultadoSorteio) {
        this.resultadoSorteio = resultadoSorteio;
    }

    //metodo para decidir o primeiro a jogar e os próximos jogadores
    private String definirValores() {
        if (getResultadoSorteio() == 1) {
            setResultadoSorteio(2);
            return "O";
        }else{
            setResultadoSorteio(1);
            return "X";
        }
    }
    
    //metodo para exibir o resultado final
    private void exibirResultado(){
        pnlLabelsMain.setVisible(false);
        pnlLabelsResultado.setVisible(true);
        pnlThird.setVisible(true);
        lbl10.setText(lbl1.getText());
        lbl11.setText(lbl2.getText());
        lbl12.setText(lbl3.getText());
        lbl13.setText(lbl4.getText());
        lbl14.setText(lbl5.getText());
        lbl15.setText(lbl6.getText());
        lbl16.setText(lbl7.getText());
        lbl17.setText(lbl8.getText());
        lbl18.setText(lbl9.getText());
    }
    
    //metodo para verificar se há vencedor até nove jogadas, senao obtiver vencedor a partida é terminada
    private void verifcarResultado(){
        numeroDejogadas++;
        if ((listaResultado[0][0] == "O" && listaResultado[0][1] == "O" && listaResultado[0][2] == "O") || (listaResultado[1][0] == "O" && listaResultado[1][1] == "O" && listaResultado[1][2] == "O") || (listaResultado[2][0] == "O" && listaResultado[2][1] == "O" && listaResultado[2][2] == "O") || /*colunas*/(listaResultado[0][0] == "O" && listaResultado[1][0] == "O" && listaResultado[2][0] == "O") || (listaResultado[0][1] == "O" && listaResultado[1][1] == "O" && listaResultado[2][1] == "O")|| (listaResultado[0][2] == "O" && listaResultado[1][2] == "O" && listaResultado[2][2] == "O") || /*diagonal*/ (listaResultado[0][0] == "O" && listaResultado[1][1] == "O" && listaResultado[2][2] == "O") || (listaResultado[2][0] == "O" && listaResultado[1][1] == "O" && listaResultado[0][2] == "O")) {
            lblWinnerResult.setText("<html>Player <font color='#00FFF3'>O</font> Winner</html>");
            exibirResultado();
        }else if ((listaResultado[0][0] == "X" && listaResultado[0][1] == "X" && listaResultado[0][2] == "X")|| (listaResultado[1][0] == "X" && listaResultado[1][1] == "X" && listaResultado[1][2] == "X") || (listaResultado[2][0] == "X" && listaResultado[2][1] == "X" && listaResultado[2][2] == "X") || /*colunas*/(listaResultado[0][0] == "X" && listaResultado[1][0] == "X" && listaResultado[2][0] == "X") || (listaResultado[0][1] == "X" && listaResultado[1][1] == "X" && listaResultado[2][1] == "X")|| (listaResultado[0][2] == "X" && listaResultado[1][2] == "X" && listaResultado[2][2] == "X") || /*diagonal*/ (listaResultado[0][0] == "X" && listaResultado[1][1] == "X" && listaResultado[2][2] == "X") || (listaResultado[2][0] == "X" && listaResultado[1][1] == "X" && listaResultado[0][2] == "X")) {
            lblWinnerResult.setText("<html>Player <font color='#EA0E0E'>X</font> Winner</html>");
            exibirResultado();
        }else if(numeroDejogadas==9){
            lblWinnerResult.setText("Match Closed");
            exibirResultado();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDeExibicao = new GradientPanel();
        pnlMain = new javax.swing.JPanel();
        lblAvisoPnlMain = new javax.swing.JLabel();
        imgVelha = new javax.swing.JLabel();
        pnlLabelsMain = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        pnlLabelsResultado = new javax.swing.JPanel();
        lbl10 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        lbl13 = new javax.swing.JLabel();
        lbl14 = new javax.swing.JLabel();
        lbl15 = new javax.swing.JLabel();
        lbl16 = new javax.swing.JLabel();
        lbl17 = new javax.swing.JLabel();
        lbl18 = new javax.swing.JLabel();
        pnlSecond = new javax.swing.JPanel();
        lblTitleTwo = new javax.swing.JLabel();
        btnJogar = new javax.swing.JButton();
        btnSortear = new javax.swing.JButton();
        lblResultadoSorteio = new javax.swing.JLabel();
        lblAvisoPnlSecond = new javax.swing.JLabel();
        lblTitleOne = new javax.swing.JLabel();
        pnlThird = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPlayAgainYes = new javax.swing.JButton();
        btnPlayAgainNo = new javax.swing.JButton();
        lblWinnerResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BlueHash");
        setBackground(new java.awt.Color(0, 0, 0));
        setFont(new java.awt.Font("Counter-Strike", 0, 10)); // NOI18N
        setForeground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        pnlDeExibicao.setPreferredSize(new java.awt.Dimension(1000, 700));
        pnlDeExibicao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setBackground(new java.awt.Color(12, 36, 68));
        pnlMain.setForeground(new java.awt.Color(60, 63, 65));
        pnlMain.setName(""); // NOI18N
        pnlMain.setPreferredSize(new java.awt.Dimension(500, 500));

        lblAvisoPnlMain.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        lblAvisoPnlMain.setForeground(new java.awt.Color(255, 0, 0));
        lblAvisoPnlMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvisoPnlMain.setText("<html><p>&#9888; Please, Choose a Valid Space &#9888;</p></html>");

        imgVelha.setBackground(new java.awt.Color(16, 42, 68));
        imgVelha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgVelha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velhaBranca.png"))); // NOI18N

        pnlLabelsMain.setBackground(new java.awt.Color(12, 36, 68));
        pnlLabelsMain.setForeground(new java.awt.Color(60, 63, 65));
        pnlLabelsMain.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlLabelsMain.setPreferredSize(new java.awt.Dimension(428, 390));

        lbl1.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl1.setForeground(new java.awt.Color(60, 63, 65));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setAlignmentY(0.0F);
        lbl1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl1MouseClicked(evt);
            }
        });

        lbl2.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl2.setForeground(new java.awt.Color(60, 63, 65));
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setAlignmentY(0.0F);
        lbl2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl2MouseClicked(evt);
            }
        });

        lbl3.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl3.setForeground(new java.awt.Color(60, 63, 65));
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl3.setAlignmentY(0.0F);
        lbl3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl3MouseClicked(evt);
            }
        });

        lbl4.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl4.setForeground(new java.awt.Color(60, 63, 65));
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4.setAlignmentY(0.0F);
        lbl4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl4.setMaximumSize(new java.awt.Dimension(35, 67));
        lbl4.setMinimumSize(new java.awt.Dimension(35, 67));
        lbl4.setName(""); // NOI18N
        lbl4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl4MouseClicked(evt);
            }
        });

        lbl5.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl5.setForeground(new java.awt.Color(60, 63, 65));
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl5.setAlignmentY(0.0F);
        lbl5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl5.setMaximumSize(new java.awt.Dimension(35, 67));
        lbl5.setMinimumSize(new java.awt.Dimension(35, 67));
        lbl5.setPreferredSize(new java.awt.Dimension(35, 67));
        lbl5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl5MouseClicked(evt);
            }
        });

        lbl6.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl6.setForeground(new java.awt.Color(60, 63, 65));
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl6.setAlignmentY(0.0F);
        lbl6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl6.setMaximumSize(new java.awt.Dimension(35, 67));
        lbl6.setMinimumSize(new java.awt.Dimension(35, 67));
        lbl6.setPreferredSize(new java.awt.Dimension(35, 67));
        lbl6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl6MouseClicked(evt);
            }
        });

        lbl7.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl7.setForeground(new java.awt.Color(60, 63, 65));
        lbl7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl7.setAlignmentY(0.0F);
        lbl7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl7MouseClicked(evt);
            }
        });

        lbl8.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl8.setForeground(new java.awt.Color(60, 63, 65));
        lbl8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl8.setAlignmentY(0.0F);
        lbl8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl8MouseClicked(evt);
            }
        });

        lbl9.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl9.setForeground(new java.awt.Color(60, 63, 65));
        lbl9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9.setAlignmentY(0.0F);
        lbl9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlLabelsMainLayout = new javax.swing.GroupLayout(pnlLabelsMain);
        pnlLabelsMain.setLayout(pnlLabelsMainLayout);
        pnlLabelsMainLayout.setHorizontalGroup(
            pnlLabelsMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLabelsMainLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pnlLabelsMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLabelsMainLayout.createSequentialGroup()
                        .addComponent(lbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLabelsMainLayout.createSequentialGroup()
                        .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLabelsMainLayout.createSequentialGroup()
                        .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3, Short.MAX_VALUE))
        );
        pnlLabelsMainLayout.setVerticalGroup(
            pnlLabelsMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLabelsMainLayout.createSequentialGroup()
                .addGroup(pnlLabelsMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLabelsMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlLabelsMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlLabelsResultado.setBackground(new java.awt.Color(12, 36, 68));
        pnlLabelsResultado.setForeground(new java.awt.Color(60, 63, 65));
        pnlLabelsResultado.setPreferredSize(new java.awt.Dimension(428, 390));

        lbl10.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl10.setForeground(new java.awt.Color(60, 63, 65));
        lbl10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl10.setAlignmentY(0.0F);
        lbl10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl11.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl11.setForeground(new java.awt.Color(60, 63, 65));
        lbl11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl11.setAlignmentY(0.0F);
        lbl11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl12.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl12.setForeground(new java.awt.Color(60, 63, 65));
        lbl12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl12.setAlignmentY(0.0F);
        lbl12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl13.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl13.setForeground(new java.awt.Color(60, 63, 65));
        lbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl13.setAlignmentY(0.0F);
        lbl13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl13.setMaximumSize(new java.awt.Dimension(35, 67));
        lbl13.setMinimumSize(new java.awt.Dimension(35, 67));
        lbl13.setName(""); // NOI18N

        lbl14.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl14.setForeground(new java.awt.Color(60, 63, 65));
        lbl14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl14.setAlignmentY(0.0F);
        lbl14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl14.setMaximumSize(new java.awt.Dimension(35, 67));
        lbl14.setMinimumSize(new java.awt.Dimension(35, 67));
        lbl14.setPreferredSize(new java.awt.Dimension(35, 67));

        lbl15.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl15.setForeground(new java.awt.Color(60, 63, 65));
        lbl15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl15.setAlignmentY(0.0F);
        lbl15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl15.setMaximumSize(new java.awt.Dimension(35, 67));
        lbl15.setMinimumSize(new java.awt.Dimension(35, 67));
        lbl15.setPreferredSize(new java.awt.Dimension(35, 67));

        lbl16.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl16.setForeground(new java.awt.Color(60, 63, 65));
        lbl16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl16.setAlignmentY(0.0F);
        lbl16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl17.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl17.setForeground(new java.awt.Color(60, 63, 65));
        lbl17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl17.setAlignmentY(0.0F);
        lbl17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl18.setFont(new java.awt.Font("Counter-Strike", 0, 50)); // NOI18N
        lbl18.setForeground(new java.awt.Color(60, 63, 65));
        lbl18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl18.setAlignmentY(0.0F);
        lbl18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlLabelsResultadoLayout = new javax.swing.GroupLayout(pnlLabelsResultado);
        pnlLabelsResultado.setLayout(pnlLabelsResultadoLayout);
        pnlLabelsResultadoLayout.setHorizontalGroup(
            pnlLabelsResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLabelsResultadoLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pnlLabelsResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLabelsResultadoLayout.createSequentialGroup()
                        .addComponent(lbl16, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl17, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl18, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLabelsResultadoLayout.createSequentialGroup()
                        .addComponent(lbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLabelsResultadoLayout.createSequentialGroup()
                        .addComponent(lbl13, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl14, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl15, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLabelsResultadoLayout.setVerticalGroup(
            pnlLabelsResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLabelsResultadoLayout.createSequentialGroup()
                .addGroup(pnlLabelsResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLabelsResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl14, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl15, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlLabelsResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl16, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl18, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl17, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlLabelsMain, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imgVelha, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlLabelsResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lblAvisoPnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLabelsMain, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgVelha, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlLabelsResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(lblAvisoPnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlDeExibicao.add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 85, -1, -1));

        pnlSecond.setBackground(new java.awt.Color(16, 42, 68));
        pnlSecond.setAlignmentX(605.0F);
        pnlSecond.setAlignmentY(201.0F);
        pnlSecond.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitleTwo.setFont(new java.awt.Font("Counter-Strike", 0, 24)); // NOI18N
        lblTitleTwo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleTwo.setText("Draft the first player:");
        lblTitleTwo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlSecond.add(lblTitleTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 40, -1, 20));

        btnJogar.setBackground(new java.awt.Color(0, 4, 40));
        btnJogar.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        btnJogar.setForeground(new java.awt.Color(255, 255, 255));
        btnJogar.setText("Start Game");
        btnJogar.setAlignmentY(0.0F);
        btnJogar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnJogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnJogarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnJogarMouseExited(evt);
            }
        });
        btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogarActionPerformed(evt);
            }
        });
        pnlSecond.add(btnJogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 150, 140, 30));

        btnSortear.setBackground(new java.awt.Color(0, 4, 40));
        btnSortear.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        btnSortear.setForeground(new java.awt.Color(255, 255, 255));
        btnSortear.setText("Draft");
        btnSortear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSortear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSortearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSortearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSortearMouseExited(evt);
            }
        });
        pnlSecond.add(btnSortear, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 90, 100, 30));

        lblResultadoSorteio.setBackground(new java.awt.Color(16, 42, 68));
        lblResultadoSorteio.setFont(new java.awt.Font("Counter-Strike", 0, 48)); // NOI18N
        lblResultadoSorteio.setForeground(new java.awt.Color(255, 255, 255));
        lblResultadoSorteio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultadoSorteio.setText("0");
        lblResultadoSorteio.setAlignmentY(0.0F);
        lblResultadoSorteio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlSecond.add(lblResultadoSorteio, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 90, 100, 30));

        lblAvisoPnlSecond.setFont(new java.awt.Font("Counter-Strike", 0, 18)); // NOI18N
        lblAvisoPnlSecond.setForeground(new java.awt.Color(255, 0, 0));
        lblAvisoPnlSecond.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvisoPnlSecond.setText("<html><p>&#9888; Draft the Player First &#9888;</p></html>");
        lblAvisoPnlSecond.setToolTipText("");
        lblAvisoPnlSecond.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlSecond.add(lblAvisoPnlSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 250, 30));

        pnlDeExibicao.add(pnlSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 207, 360, -1));

        lblTitleOne.setFont(new java.awt.Font("Centaur", 0, 48)); // NOI18N
        lblTitleOne.setForeground(new java.awt.Color(0, 204, 102));
        lblTitleOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleOne.setText("Welcome to BlueHash");
        pnlDeExibicao.add(lblTitleOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, 40));

        pnlThird.setAlignmentX(0.0F);
        pnlThird.setAlignmentY(0.0F);
        pnlThird.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Counter-Strike", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Want To Play Again?");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlThird.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 82, -1, 27));

        btnPlayAgainYes.setBackground(new java.awt.Color(0, 4, 40));
        btnPlayAgainYes.setFont(new java.awt.Font("Counter-Strike", 0, 20)); // NOI18N
        btnPlayAgainYes.setForeground(new java.awt.Color(255, 255, 255));
        btnPlayAgainYes.setText("Yes");
        btnPlayAgainYes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPlayAgainYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayAgainYesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayAgainYesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayAgainYesMouseExited(evt);
            }
        });
        pnlThird.add(btnPlayAgainYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 143, 80, 25));

        btnPlayAgainNo.setBackground(new java.awt.Color(0, 4, 40));
        btnPlayAgainNo.setFont(new java.awt.Font("Counter-Strike", 0, 20)); // NOI18N
        btnPlayAgainNo.setForeground(new java.awt.Color(255, 255, 255));
        btnPlayAgainNo.setText("No");
        btnPlayAgainNo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPlayAgainNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayAgainNoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlayAgainNoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlayAgainNoMouseExited(evt);
            }
        });
        pnlThird.add(btnPlayAgainNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 143, 80, 25));

        lblWinnerResult.setFont(new java.awt.Font("Counter-Strike", 0, 36)); // NOI18N
        lblWinnerResult.setForeground(new java.awt.Color(255, 255, 255));
        lblWinnerResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWinnerResult.setText("Player O Winner");
        lblWinnerResult.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlThird.add(lblWinnerResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 16, 306, 29));

        pnlDeExibicao.add(pnlThird, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 221, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDeExibicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDeExibicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1017, 688));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSortearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortearMouseEntered
        btnSortear.setBackground(Color.decode("#870000"));
    }//GEN-LAST:event_btnSortearMouseEntered

    private void btnSortearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortearMouseExited
        btnSortear.setBackground(Color.decode("#000428"));
    }//GEN-LAST:event_btnSortearMouseExited

    private void btnSortearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortearMouseClicked
        //define variavel 'decisao' para True
        setDecisao(true);
        
        lblResultadoSorteio.setVisible(true);
        btnSortear.setVisible(false);
        lblAvisoPnlSecond.setVisible(false);
        
        //exibe resultado do sorteio na tela
        setResultadoSorteio(sortear.nextInt(1, 3));
        if ( getResultadoSorteio() == 1) {
            lblResultadoSorteio.setText("<html><font color='#00FFF3'>O</font></html>");
        } else {
            lblResultadoSorteio.setText("<html><font color='#EA0E0E'>X</font></html>");
        }
        lblResultadoSorteio.setVisible(true);
    }//GEN-LAST:event_btnSortearMouseClicked
    
    private void btnJogarMouseEntered(java.awt.event.MouseEvent evt) {                                      
        btnJogar.setBackground(Color.decode("#870000"));
    }                                     

    private void btnJogarMouseExited(java.awt.event.MouseEvent evt) {                                     
        btnJogar.setBackground(Color.decode("#000428"));
    }          
                              
    private void btnJogarActionPerformed(java.awt.event.ActionEvent evt) {
        //condicional para verificar se o botao de sortear foi clicado, se sim a partida inicia, senao exibe uma mensagem de erro
        if(isDecisao() != false){
            lblAvisoPnlSecond.setVisible(false);
            pnlSecond.setVisible(false);
            pnlLabelsMain.setVisible(true);
        }else{
            lblAvisoPnlSecond.setVisible(true);
        }
    }
    
    private void btnPlayAgainYesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayAgainYesMouseEntered
        btnPlayAgainYes.setBackground(Color.decode("#870000"));
    }//GEN-LAST:event_btnPlayAgainYesMouseEntered

    private void btnPlayAgainYesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayAgainYesMouseExited
        btnPlayAgainYes.setBackground(Color.decode("#000428"));
    }//GEN-LAST:event_btnPlayAgainYesMouseExited

    private void btnPlayAgainYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayAgainYesMouseClicked
        //resetar labels
        JLabel label;
        for (int i = 0; i <= 8; i++) {
            label = (JLabel) pnlLabelsMain.getComponent(i);            
            label.setText("");
        }
        for (int i = 0; i <= 8; i++) {
            label = (JLabel) pnlLabelsResultado.getComponent(i);
            label.setText("");
        }
        //resetar vetor
        for (int linha = 0; linha < listaResultado.length; linha++) {
            for (int coluna = 0; coluna < listaResultado.length; coluna++) {
                listaResultado[linha][coluna]= "";
            }
        }
        
        //resetar labels,botoes, painéis e variaveis para padrão de inicio
       
        numeroDejogadas = 0;
        pnlMain.setVisible(true);
        pnlLabelsMain.setVisible(false);
        pnlLabelsResultado.setVisible(false);
        lblAvisoPnlMain.setVisible(false);
        
        pnlSecond.setVisible(true);
        btnSortear.setVisible(true);
        lblResultadoSorteio.setVisible(false);
        lblAvisoPnlSecond.setVisible(false);
        lblResultadoSorteio.setVisible(false);
        
        pnlThird.setVisible(false);
        
        setDecisao(false);
       
    }//GEN-LAST:event_btnPlayAgainYesMouseClicked

    private void btnPlayAgainNoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayAgainNoMouseEntered
        
        btnPlayAgainNo.setBackground(Color.decode("#870000"));
    }//GEN-LAST:event_btnPlayAgainNoMouseEntered

    private void btnPlayAgainNoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayAgainNoMouseExited
        
        btnPlayAgainNo.setBackground(Color.decode("#000428"));
    }//GEN-LAST:event_btnPlayAgainNoMouseExited

    private void btnPlayAgainNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayAgainNoMouseClicked
        
        System.exit(0);
    }//GEN-LAST:event_btnPlayAgainNoMouseClicked
    /*
    A condicional dentro dos eventos de click das labels verifica se a label esta vazia.
    Se sim: desativa a mensagem de aviso, verifica se o jogador é O ou X, insere valor na label e no seu vetor na posição conrrespondente.
    Senao: exibe uma mensagem de erro que a label ja esta ocupada.
    Essa condicional é aplicada em todas as noves primeiras labels.
    */
    private void lbl1MouseClicked(java.awt.event.MouseEvent evt) {   
        
        if (lbl1.getText() == "") {
            lblAvisoPnlMain.setVisible(false);
            if (definirValores() == "O") {
                lbl1.setText("<html><font color='#00FFF3'>O</font></html>");
                listaResultado[0][0] = "O";
            } else {
                lbl1.setText("<html><font color='#EA0E0E'>X</font></html>");
                listaResultado[0][0] = "X";
            }
            verifcarResultado();
        } else {
            lblAvisoPnlMain.setVisible(true);
        }

    }                                  

    private void lbl2MouseClicked(java.awt.event.MouseEvent evt) {                                     
        if (lbl2.getText() == "") {
            lblAvisoPnlMain.setVisible(false);
            if (definirValores() == "O") {
                lbl2.setText("<html><font color='#00FFF3'>O</font></html>");
                listaResultado[0][1] = "O";
            } else {
                lbl2.setText("<html><font color='#EA0E0E'>X</font></html>");
                listaResultado[0][1] = "X";
            }
            verifcarResultado();
        } else {
            lblAvisoPnlMain.setVisible(true);
        }
    }                                    

    private void lbl3MouseClicked(java.awt.event.MouseEvent evt) {                                     
       if (lbl3.getText() == "") {
            lblAvisoPnlMain.setVisible(false);
            if (definirValores() == "O") {
                lbl3.setText("<html><font color='#00FFF3'>O</font></html>");
                listaResultado[0][2] = "O";
            } else {
                lbl3.setText("<html><font color='#EA0E0E'>X</font></html>");
                listaResultado[0][2] = "X";
            }
            verifcarResultado();
        } else {
            lblAvisoPnlMain.setVisible(true);
        }
    }                                    

    private void lbl4MouseClicked(java.awt.event.MouseEvent evt) {                                       
        if (lbl4.getText() == "") {
            lblAvisoPnlMain.setVisible(false);
            if (definirValores() == "O") {
                lbl4.setText("<html><font color='#00FFF3'>O</font></html>");
                listaResultado[1][0] = "O";
            } else {
                lbl4.setText("<html><font color='#EA0E0E'>X</font></html>");
                listaResultado[1][0] = "X";
            }
            verifcarResultado();
        } else {
            lblAvisoPnlMain.setVisible(true);
        }
    }                                      

    private void lbl5MouseClicked(java.awt.event.MouseEvent evt) {                                      
       if (lbl5.getText() == "") {
            lblAvisoPnlMain.setVisible(false);
            if (definirValores() == "O") {
                lbl5.setText("<html><font color='#00FFF3'>O</font></html>");
                listaResultado[1][1] = "O";
            } else {
                lbl5.setText("<html><font color='#EA0E0E'>X</font></html>");
                listaResultado[1][1] = "X";
            }
            verifcarResultado();
        } else {
            lblAvisoPnlMain.setVisible(true);
        }
    }                                     

    private void lbl6MouseClicked(java.awt.event.MouseEvent evt) {                                     
       if (lbl6.getText() == "") {
            lblAvisoPnlMain.setVisible(false);
            if (definirValores() == "O") {
                lbl6.setText("<html><font color='#00FFF3'>O</font></html>");
                listaResultado[1][2] = "O";
            } else {
                lbl6.setText("<html><font color='#EA0E0E'>X</font></html>");
                listaResultado[1][2] = "X";
            }
            verifcarResultado();
        } else {
            lblAvisoPnlMain.setVisible(true);
        }
    }                                    

    private void lbl7MouseClicked(java.awt.event.MouseEvent evt) {                                     
        if (lbl7.getText() == "") {
            lblAvisoPnlMain.setVisible(false);
            if (definirValores() == "O") {
                lbl7.setText("<html><font color='#00FFF3'>O</font></html>");
                listaResultado[2][0] = "O";
            } else {
                lbl7.setText("<html><font color='#EA0E0E'>X</font></html>");
                listaResultado[2][0] = "X";
            }
            verifcarResultado();
        } else {
            lblAvisoPnlMain.setVisible(true);
        }
    }                                    

    private void lbl8MouseClicked(java.awt.event.MouseEvent evt) {                                     
       if (lbl8.getText() == "") {
            lblAvisoPnlMain.setVisible(false);
            if (definirValores() == "O") {
                lbl8.setText("<html><font color='#00FFF3'>O</font></html>");
                listaResultado[2][1] = "O";
            } else {
                lbl8.setText("<html><font color='#EA0E0E'>X</font></html>");
                listaResultado[2][1] = "X";
            }
            verifcarResultado();
        } else {
            lblAvisoPnlMain.setVisible(true);
        }
    }                                    
    
    private void lbl9MouseClicked(java.awt.event.MouseEvent evt) {                                     
        if (lbl9.getText() == "") {
            lblAvisoPnlMain.setVisible(false);
            if (definirValores() == "O") {
                lbl9.setText("<html><font color='#00FFF3'>O</font></html>");
                listaResultado[2][2] = "O";
            } else {
                lbl9.setText("<html><font color='#EA0E0E'>X</font></html>");
                listaResultado[2][2] = "X";
            }
            verifcarResultado();
        } else {
            lblAvisoPnlMain.setVisible(true);
        }
    }                                    

  
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BlueHash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlueHash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlueHash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlueHash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BlueHash().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJogar;
    private javax.swing.JButton btnPlayAgainNo;
    private javax.swing.JButton btnPlayAgainYes;
    private javax.swing.JButton btnSortear;
    private javax.swing.JLabel imgVelha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl13;
    private javax.swing.JLabel lbl14;
    private javax.swing.JLabel lbl15;
    private javax.swing.JLabel lbl16;
    private javax.swing.JLabel lbl17;
    private javax.swing.JLabel lbl18;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel lblAvisoPnlMain;
    private javax.swing.JLabel lblAvisoPnlSecond;
    private javax.swing.JLabel lblResultadoSorteio;
    private javax.swing.JLabel lblTitleOne;
    private javax.swing.JLabel lblTitleTwo;
    private javax.swing.JLabel lblWinnerResult;
    private javax.swing.JPanel pnlDeExibicao;
    private javax.swing.JPanel pnlLabelsMain;
    private javax.swing.JPanel pnlLabelsResultado;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSecond;
    private javax.swing.JPanel pnlThird;
    // End of variables declaration//GEN-END:variables
 
}
