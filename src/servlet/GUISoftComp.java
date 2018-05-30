package Soft;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUISoftComp extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField WahrscheinlichkeitTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISoftComp frame = new GUISoftComp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUISoftComp() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 1, 205, 154, 44, 131, 50, 150, 0 };
		gbl_contentPane.rowHeights = new int[] { 1, 20, 35, 15, 23, 23, 15, 23, 23, 15, 23, 26, 23, 14, 14, 39, 23, 15, 15, 22, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel GenerationenAnzahllbl = new JLabel("");
		GridBagConstraints gbc_GenerationenAnzahllbl = new GridBagConstraints();
		gbc_GenerationenAnzahllbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_GenerationenAnzahllbl.insets = new Insets(0, 0, 5, 5);
		gbc_GenerationenAnzahllbl.gridx = 0;
		gbc_GenerationenAnzahllbl.gridy = 0;
		contentPane.add(GenerationenAnzahllbl, gbc_GenerationenAnzahllbl);

		JLabel PopulationAnzahllbl = new JLabel("");
		GridBagConstraints gbc_PopulationAnzahllbl = new GridBagConstraints();
		gbc_PopulationAnzahllbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_PopulationAnzahllbl.insets = new Insets(0, 0, 5, 5);
		gbc_PopulationAnzahllbl.gridx = 0;
		gbc_PopulationAnzahllbl.gridy = 0;
		contentPane.add(PopulationAnzahllbl, gbc_PopulationAnzahllbl);

		JLabel IndividuenAnzahllbl = new JLabel("");
		GridBagConstraints gbc_IndividuenAnzahllbl = new GridBagConstraints();
		gbc_IndividuenAnzahllbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_IndividuenAnzahllbl.insets = new Insets(0, 0, 5, 5);
		gbc_IndividuenAnzahllbl.gridx = 0;
		gbc_IndividuenAnzahllbl.gridy = 0;
		contentPane.add(IndividuenAnzahllbl, gbc_IndividuenAnzahllbl);

		JLabel wertFitnesslbl = new JLabel("");
		GridBagConstraints gbc_wertFitnesslbl = new GridBagConstraints();
		gbc_wertFitnesslbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_wertFitnesslbl.insets = new Insets(0, 0, 5, 5);
		gbc_wertFitnesslbl.gridx = 0;
		gbc_wertFitnesslbl.gridy = 0;
		contentPane.add(wertFitnesslbl, gbc_wertFitnesslbl);

		JLabel Ueberschriftlbl = new JLabel("Softcomputing - Vertragsgestaltungsproblem");
		Ueberschriftlbl.setForeground(Color.BLUE);
		Ueberschriftlbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_Ueberschriftlbl = new GridBagConstraints();
		gbc_Ueberschriftlbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_Ueberschriftlbl.insets = new Insets(0, 0, 5, 5);
		gbc_Ueberschriftlbl.gridwidth = 2;
		gbc_Ueberschriftlbl.gridx = 1;
		gbc_Ueberschriftlbl.gridy = 1;
		contentPane.add(Ueberschriftlbl, gbc_Ueberschriftlbl);

		JLabel lblBild = new JLabel("");
		lblBild.setIcon(new ImageIcon(GUISoftComp.class.getResource("/Soft/Softcat_small.png")));
		GridBagConstraints gbc_lblBild = new GridBagConstraints();
		gbc_lblBild.gridwidth = 2;
		gbc_lblBild.anchor = GridBagConstraints.WEST;
		gbc_lblBild.insets = new Insets(0, 0, 5, 0);
		gbc_lblBild.gridheight = 6;
		gbc_lblBild.gridx = 5;
		gbc_lblBild.gridy = 1;
		contentPane.add(lblBild, gbc_lblBild);

		JLabel lblCrossover = new JLabel("Crossover");
		lblCrossover.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblCrossover = new GridBagConstraints();
		gbc_lblCrossover.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblCrossover.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrossover.gridx = 1;
		gbc_lblCrossover.gridy = 3;
		contentPane.add(lblCrossover, gbc_lblCrossover);

		JRadioButton EinPunktRadiobtn = new JRadioButton("Ein-Punkt-Crossover");
		buttonGroup.add(EinPunktRadiobtn);
		GridBagConstraints gbc_EinPunktRadiobtn = new GridBagConstraints();
		gbc_EinPunktRadiobtn.anchor = GridBagConstraints.NORTHWEST;
		gbc_EinPunktRadiobtn.insets = new Insets(0, 0, 5, 5);
		gbc_EinPunktRadiobtn.gridx = 1;
		gbc_EinPunktRadiobtn.gridy = 4;
		contentPane.add(EinPunktRadiobtn, gbc_EinPunktRadiobtn);

		JRadioButton UniformCrossRadiobtn = new JRadioButton("Uniform-Crossover");
		buttonGroup.add(UniformCrossRadiobtn);
		GridBagConstraints gbc_UniformCrossRadiobtn = new GridBagConstraints();
		gbc_UniformCrossRadiobtn.anchor = GridBagConstraints.NORTHWEST;
		gbc_UniformCrossRadiobtn.insets = new Insets(0, 0, 5, 5);
		gbc_UniformCrossRadiobtn.gridx = 1;
		gbc_UniformCrossRadiobtn.gridy = 5;
		contentPane.add(UniformCrossRadiobtn, gbc_UniformCrossRadiobtn);

		JLabel Mutationlbl = new JLabel("Mutation");
		Mutationlbl.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_Mutationlbl = new GridBagConstraints();
		gbc_Mutationlbl.anchor = GridBagConstraints.SOUTHWEST;
		gbc_Mutationlbl.insets = new Insets(0, 0, 5, 5);
		gbc_Mutationlbl.gridx = 1;
		gbc_Mutationlbl.gridy = 6;
		contentPane.add(Mutationlbl, gbc_Mutationlbl);

		JRadioButton FlipMutaRadioButton = new JRadioButton("Flip-Mutation");
		buttonGroup_1.add(FlipMutaRadioButton);
		GridBagConstraints gbc_FlipMutaRadioButton = new GridBagConstraints();
		gbc_FlipMutaRadioButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_FlipMutaRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_FlipMutaRadioButton.gridx = 1;
		gbc_FlipMutaRadioButton.gridy = 7;
		contentPane.add(FlipMutaRadioButton, gbc_FlipMutaRadioButton);

		JRadioButton SwapMutRadiobtn = new JRadioButton("Swap-Mutation");
		buttonGroup_1.add(SwapMutRadiobtn);
		GridBagConstraints gbc_SwapMutRadiobtn = new GridBagConstraints();
		gbc_SwapMutRadiobtn.anchor = GridBagConstraints.NORTHWEST;
		gbc_SwapMutRadiobtn.insets = new Insets(0, 0, 5, 5);
		gbc_SwapMutRadiobtn.gridx = 1;
		gbc_SwapMutRadiobtn.gridy = 8;
		contentPane.add(SwapMutRadiobtn, gbc_SwapMutRadiobtn);

		JLabel lblParameter = new JLabel("Parameter");
		lblParameter.setForeground(new Color(0, 0, 0));
		lblParameter.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblParameter = new GridBagConstraints();
		gbc_lblParameter.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblParameter.insets = new Insets(0, 0, 5, 5);
		gbc_lblParameter.gridx = 4;
		gbc_lblParameter.gridy = 8;
		contentPane.add(lblParameter, gbc_lblParameter);

		JLabel lblSelektion = new JLabel("Selektion");
		lblSelektion.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblSelektion = new GridBagConstraints();
		gbc_lblSelektion.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblSelektion.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelektion.gridx = 1;
		gbc_lblSelektion.gridy = 9;
		contentPane.add(lblSelektion, gbc_lblSelektion);

		JLabel lblWahrscheinlichkeit = new JLabel("Wahrscheinlichkeit in %:");
		GridBagConstraints gbc_lblWahrscheinlichkeit = new GridBagConstraints();
		gbc_lblWahrscheinlichkeit.anchor = GridBagConstraints.EAST;
		gbc_lblWahrscheinlichkeit.insets = new Insets(0, 0, 5, 5);
		gbc_lblWahrscheinlichkeit.gridx = 4;
		gbc_lblWahrscheinlichkeit.gridy = 9;
		contentPane.add(lblWahrscheinlichkeit, gbc_lblWahrscheinlichkeit);

		WahrscheinlichkeitTextField = new JTextField();
		GridBagConstraints gbc_WahrscheinlichkeitTextField = new GridBagConstraints();
		gbc_WahrscheinlichkeitTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_WahrscheinlichkeitTextField.insets = new Insets(0, 0, 5, 0);
		gbc_WahrscheinlichkeitTextField.gridx = 5;
		gbc_WahrscheinlichkeitTextField.gridy = 9;
		contentPane.add(WahrscheinlichkeitTextField, gbc_WahrscheinlichkeitTextField);
		WahrscheinlichkeitTextField.setColumns(10);

		JRadioButton GenRepRadiobtn = new JRadioButton("Generational-Replacement (Nachkommenselektion)");
		buttonGroup_2.add(GenRepRadiobtn);
		GenRepRadiobtn.setToolTipText("");
		GridBagConstraints gbc_GenRepRadiobtn = new GridBagConstraints();
		gbc_GenRepRadiobtn.anchor = GridBagConstraints.NORTHWEST;
		gbc_GenRepRadiobtn.insets = new Insets(0, 0, 5, 5);
		gbc_GenRepRadiobtn.gridwidth = 2;
		gbc_GenRepRadiobtn.gridx = 1;
		gbc_GenRepRadiobtn.gridy = 10;
		contentPane.add(GenRepRadiobtn, gbc_GenRepRadiobtn);

		JRadioButton SteadystateRadioBtn = new JRadioButton("Steady-State (Nachkommenselektion)");
		buttonGroup_2.add(SteadystateRadioBtn);
		GridBagConstraints gbc_SteadystateRadioBtn = new GridBagConstraints();
		gbc_SteadystateRadioBtn.anchor = GridBagConstraints.WEST;
		gbc_SteadystateRadioBtn.insets = new Insets(0, 0, 5, 5);
		gbc_SteadystateRadioBtn.gridx = 1;
		gbc_SteadystateRadioBtn.gridy = 11;
		contentPane.add(SteadystateRadioBtn, gbc_SteadystateRadioBtn);

		JSlider slider = new JSlider();
		slider.setValue(100);
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.anchor = GridBagConstraints.NORTH;
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.insets = new Insets(0, 0, 5, 0);
		gbc_slider.gridwidth = 2;
		gbc_slider.gridx = 4;
		gbc_slider.gridy = 11;
		contentPane.add(slider, gbc_slider);

		JRadioButton RankSelektionRadiobtn = new JRadioButton("Rank-Selektion (Elternselektion)");
		buttonGroup_2.add(RankSelektionRadiobtn);
		GridBagConstraints gbc_RankSelektionRadiobtn = new GridBagConstraints();
		gbc_RankSelektionRadiobtn.anchor = GridBagConstraints.NORTHWEST;
		gbc_RankSelektionRadiobtn.insets = new Insets(0, 0, 5, 5);
		gbc_RankSelektionRadiobtn.gridx = 1;
		gbc_RankSelektionRadiobtn.gridy = 12;
		contentPane.add(RankSelektionRadiobtn, gbc_RankSelektionRadiobtn);

		JLabel Populationlbl = new JLabel("Population:");
		GridBagConstraints gbc_Populationlbl = new GridBagConstraints();
		gbc_Populationlbl.anchor = GridBagConstraints.WEST;
		gbc_Populationlbl.insets = new Insets(0, 0, 5, 5);
		gbc_Populationlbl.gridx = 4;
		gbc_Populationlbl.gridy = 12;
		contentPane.add(Populationlbl, gbc_Populationlbl);

		JLabel Generationlbl = new JLabel("Generationen:");
		GridBagConstraints gbc_Generationlbl = new GridBagConstraints();
		gbc_Generationlbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_Generationlbl.insets = new Insets(0, 0, 5, 5);
		gbc_Generationlbl.gridx = 4;
		gbc_Generationlbl.gridy = 13;
		contentPane.add(Generationlbl, gbc_Generationlbl);

		JLabel lblIndividuen = new JLabel("Individuen:");
		GridBagConstraints gbc_lblIndividuen = new GridBagConstraints();
		gbc_lblIndividuen.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblIndividuen.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndividuen.gridx = 4;
		gbc_lblIndividuen.gridy = 14;
		contentPane.add(lblIndividuen, gbc_lblIndividuen);

		JButton CalcBtn = new JButton("Go, Go, Powerrangers!");
		GridBagConstraints gbc_CalcBtn = new GridBagConstraints();
		gbc_CalcBtn.anchor = GridBagConstraints.NORTH;
		gbc_CalcBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_CalcBtn.insets = new Insets(0, 0, 5, 5);
		gbc_CalcBtn.gridwidth = 3;
		gbc_CalcBtn.gridx = 2;
		gbc_CalcBtn.gridy = 16;
		contentPane.add(CalcBtn, gbc_CalcBtn);

		JLabel lblFitness = new JLabel("Fitness:");
		lblFitness.setFont(new Font("Tahoma", Font.ITALIC, 12));
		GridBagConstraints gbc_lblFitness = new GridBagConstraints();
		gbc_lblFitness.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblFitness.insets = new Insets(0, 0, 5, 5);
		gbc_lblFitness.gridx = 1;
		gbc_lblFitness.gridy = 18;
		contentPane.add(lblFitness, gbc_lblFitness);

		JLabel Fitnesswertlbl = new JLabel("");
		GridBagConstraints gbc_Fitnesswertlbl = new GridBagConstraints();
		gbc_Fitnesswertlbl.insets = new Insets(0, 0, 5, 5);
		gbc_Fitnesswertlbl.gridx = 2;
		gbc_Fitnesswertlbl.gridy = 18;
		contentPane.add(Fitnesswertlbl, gbc_Fitnesswertlbl);

		JLabel lblBesteLoesung = new JLabel("Beste L\u00F6sung:");
		lblBesteLoesung.setFont(new Font("Tahoma", Font.ITALIC, 12));
		GridBagConstraints gbc_lblBesteLoesung = new GridBagConstraints();
		gbc_lblBesteLoesung.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblBesteLoesung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBesteLoesung.gridx = 1;
		gbc_lblBesteLoesung.gridy = 19;
		contentPane.add(lblBesteLoesung, gbc_lblBesteLoesung);

		JLabel Loesungswertlbl = new JLabel("");
		GridBagConstraints gbc_Loesungswertlbl = new GridBagConstraints();
		gbc_Loesungswertlbl.fill = GridBagConstraints.HORIZONTAL;
		gbc_Loesungswertlbl.insets = new Insets(0, 0, 5, 5);
		gbc_Loesungswertlbl.gridx = 2;
		gbc_Loesungswertlbl.gridy = 19;
		contentPane.add(Loesungswertlbl, gbc_Loesungswertlbl);

		JLabel lblallesgenial = new JLabel("#AllesGenial");
		lblallesgenial.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_lblallesgenial = new GridBagConstraints();
		gbc_lblallesgenial.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblallesgenial.insets = new Insets(0, 0, 0, 5);
		gbc_lblallesgenial.gridx = 1;
		gbc_lblallesgenial.gridy = 20;
		contentPane.add(lblallesgenial, gbc_lblallesgenial);
	}

}
