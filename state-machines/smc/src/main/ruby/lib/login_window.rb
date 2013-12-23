require 'java'

java_import java.awt.event.ActionListener
java_import java.awt.Dimension
java_import javax.swing.JButton
java_import javax.swing.JFrame

#
# A few comments
#

class ClickAction
  include ActionListener

  def actionPerformed(event)
    puts 'Button clicked'
  end
end

class LoginWindow < JFrame
  def initialize
    super 'Login Demo'
    setDefaultCloseOperation JFrame::EXIT_ON_CLOSE

    button = JButton.new "Login"
    button.addActionListener ClickAction.new
    add button

    getContentPane.setPreferredSize(Dimension.new(400, 100))

    pack
  end
end

LoginWindow.new.setVisible true
