package gui;
import Data.FileIO;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DisplayList extends JFrame {

    private static final long serialVersionUID = 1L;
    static DefaultListModel<String> arr = new DefaultListModel<>();
    private JPanel contentPane;
    private JList<String> list;

    /**
     * Create the frame.
     */
    public DisplayList() {
        setTitle("Account List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 649, 474);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAccountList = new JLabel("Account List");
        lblAccountList.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblAccountList.setHorizontalAlignment(SwingConstants.CENTER);
        lblAccountList.setBounds(0, 11, 623, 31);
        contentPane.add(lblAccountList);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 66, 613, 358);
        contentPane.add(scrollPane);

        arr = FileIO.bank.display();
        list = new JList<>(arr);
        scrollPane.setViewportView(list);
    }

    // 🔥 THIS IS THE IMPORTANT PART
    public void refreshList() {
        arr = FileIO.bank.display();  // get fresh updated list
        list.setModel(arr);           // update the JList
    }
}
