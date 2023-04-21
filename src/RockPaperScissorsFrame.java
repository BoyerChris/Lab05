import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame
{
    JPanel mainPnl, gamePnl, statPnl, textPnl;
    JButton rockBtn, paperBtn, ScissorBtn, quitBtn;
    JTextArea resultsTA;
    JScrollPane resultsPane;
    ImageIcon rockIcn, paperIcn, scissorIcn, quitIcn;
    JLabel winLbl, loseLbl, tieLbl;
    JTextField winField, loseField, tieField;
    private int playerwins = 0;
    private int playerlosses = 0;
    private int playerties = 0;
    String playerGuess = "";
    private int rock = 0;
    private int paper = 0;
    private int scissors = 0;
    private int randomGuess;


    public RockPaperScissorsFrame()
    {
        createGUI();
        setTitle("Rock Paper Scissors Game");
        setSize(1200, 675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createGUI()
    {
        mainPnl = new JPanel();
        gamePnl = new JPanel();
        statPnl = new JPanel();
        textPnl = new JPanel();

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(gamePnl, BorderLayout.NORTH);
        mainPnl.add(statPnl, BorderLayout.CENTER);
        mainPnl.add(textPnl, BorderLayout.SOUTH);

        add(mainPnl);
        createTopPnl();
        createCenterPnl();
        createBottomPnl();
    }

    private void createTopPnl()
    {
        rockIcn = new ImageIcon("src\\Rock.png");
        paperIcn = new ImageIcon("src\\Paper.png");
        scissorIcn = new ImageIcon("src\\Scissors.png");
        quitIcn = new ImageIcon("src\\Exit.png");

        quitBtn = new JButton(quitIcn);
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        rockBtn = new JButton(rockIcn);
        rockBtn.addActionListener((ActionEvent ae) -> {
            String playerGuess = "Rock";
            rock++;
            rockStrategy();});

        paperBtn = new JButton(paperIcn);
        paperBtn.addActionListener((ActionEvent ae) -> {
            String playerGuess = "Paper";
            paper++;
            paperStrategy();});

        ScissorBtn = new JButton(scissorIcn);
        ScissorBtn.addActionListener((ActionEvent ae) -> {
            String playerGuess = "Scissors";
            scissors++;
            scissorStrategy();});


        gamePnl.setLayout(new GridLayout(1, 4));
        gamePnl.add(quitBtn);
        gamePnl.add(rockBtn);
        gamePnl.add(paperBtn);
        gamePnl.add(ScissorBtn);
    }

    private void createCenterPnl()
    {
        winField = new JTextField(playerwins);
        loseField = new JTextField(playerlosses);
        tieField = new JTextField(playerties);

        winLbl = new JLabel("Your Wins: ");
        loseLbl = new JLabel("Computer Wins: ");
        tieLbl = new JLabel("Ties: ");

        statPnl.add(winLbl);
        statPnl.add(winField);
        statPnl.add(loseLbl);
        statPnl.add(loseField);
        statPnl.add(tieLbl);
        statPnl.add(tieField);
    }

    private void createBottomPnl()
    {
        resultsTA = new JTextArea(20, 50);
        resultsPane = new JScrollPane(resultsTA);
        textPnl.add(resultsPane);
    }

    private void UpdateCounter()
    {
        winField.setText(String.valueOf(playerwins));
        loseField.setText(String.valueOf(playerlosses));
        tieField.setText(String.valueOf(playerties));
        validate();
    }

    private void rockStrategy()
    {
        Random rand = new Random();
        randomGuess = rand.nextInt(3);


        if (randomGuess == 0) {
            String response = "Rock breaks scissors (Player wins)";
            resultsTA.append(response + "\n");
            playerwins++;
        }
        else if (randomGuess == 1) {
            String response = "Rock ties with rock (Tie)";
            resultsTA.append(response + "\n");
            playerties++;
        }
        else if (randomGuess == 2) {
            String response = "Paper covers rock (Computer wins)";
            resultsTA.append(response + "\n");
            playerlosses++;

        }
        UpdateCounter();
    }

    private void paperStrategy()
    {
        Random rand = new Random();
        randomGuess = rand.nextInt(3);


        if (randomGuess == 0) {
            String response = "Paper covers rock (Player wins)";
            resultsTA.append(response + "\n");
            playerwins++;
        }
        else if (randomGuess == 1) {
            String response = "Paper ties with paper (Tie)";
            resultsTA.append(response + "\n");
            playerties++;
        }
        else if (randomGuess == 2) {
            String response = "Scissors cuts paper (Computer wins)";
            resultsTA.append(response + "\n");
            playerlosses++;

        }
        UpdateCounter();
    }

    private void scissorStrategy()
    {
        Random rand = new Random();
        randomGuess = rand.nextInt(3);


        if (randomGuess == 0) {
            String response = "Scissors cuts paper (Player wins)";
            resultsTA.append(response + "\n");
            playerwins++;
        }
        else if (randomGuess == 1) {
            String response = "Scissors ties with scissors (Tie)";
            resultsTA.append(response + "\n");
            playerties++;
        }
        else if (randomGuess == 2) {
            String response = "Rock breaks scissors (Computer wins)";
            resultsTA.append(response + "\n");
            playerlosses++;

        }
        UpdateCounter();
    }
}
