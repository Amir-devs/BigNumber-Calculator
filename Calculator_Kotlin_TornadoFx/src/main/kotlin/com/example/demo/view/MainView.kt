package com.example.demo.view

import com.example.demo.Controller.Functions
import javafx.scene.image.Image
import tornadofx.*
import java.net.URL

class MainView : View("Calculator") {

    init {
        setStageIcon(Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2BTrvmhmGWGCUPTVGKLdDqgtbRm7-AIrJoA&usqp=CAU"))
    }

    var textArea = textarea { setPrefSize( 600.0 , 100.0 ) ;  style = "-fx-text-fill: black; -fx-background-color: black; -fx-font-size: 30px" }


    var operator = ""

    private fun calculte(operatorKeyboard : String)
    {
        operator = operatorKeyboard
        var textBar : String = textArea.text

        if ( textBar.contains("--") )
        {
            textBar = textBar.replace("--","+")
            operator = "+"
        }
        if ( textBar.contains("-+" ) || textBar.contains("+-" ) )
        {
            textBar = textBar.replace("-+","-")
            textBar = textBar.replace("+-","-")
            this.operator = "-"
        }

        if ( textBar[0] == '+' )
        {
            textBar = textBar.substring(1)
        }

        val numbers = textBar.split(operator)

        val functions = Functions()
        when (operator)
        {
            "+" -> textArea.text = functions.plus(numbers)
            "-" -> textArea.text = functions.minus(numbers)
            "*" -> textArea.text = functions.multi(numbers)
            "/" -> { textArea.style = "-fx-font-size: 25px" ; textArea.text = functions.divide(numbers) }
            "^" -> textArea.text = functions.pow(numbers)
        }
    }


    override val root = anchorpane {
        setMinSize(500.0 , 300.0)
        style = "-fx-background-color: black"
        val functions = Functions()


        val column1 = vbox {
            val styleNumber = "-fx-background-color: #FBFBFB; -fx-background-radius: 50 ; -fx-font-size: 20px ;"
            add(button { text = "1" ; setPrefSize(100.0 , 100.0) ; style = styleNumber ; action { textArea.text += text }})
            add(button { text = "4" ; setPrefSize(100.0 , 100.0) ; style = styleNumber ; action { textArea.text += text }})
            add(button { text = "7" ; setPrefSize(100.0 , 100.0) ; style = styleNumber ; action { textArea.text += text }})
            add(button { text = "0" ; setPrefSize(100.0 , 100.0) ; style = styleNumber ; action { textArea.text += text }})
            spacing = 2.0
        }

        val column2 = vbox {
            val styleNumber = "-fx-background-color: #FBFBFB; -fx-background-radius: 50 ; -fx-font-size: 20px ;"
            add(button { text = "2" ; setPrefSize(100.0 , 100.0) ; style = styleNumber ; action { textArea.text += text }})
            add(button { text = "5" ; setPrefSize(100.0 , 100.0) ; style = styleNumber ; action { textArea.text += text }})
            add(button { text = "8" ; setPrefSize(100.0 , 100.0) ; style = styleNumber ; action { textArea.text += text }})
            spacing = 2.0
        }

        val column3 = vbox {
            val styleNumber = "-fx-background-color: #FBFBFB; -fx-background-radius: 50 ; -fx-font-size: 20px ;"
            add(button { text = "3" ; setPrefSize(100.0 , 100.0) ; style = styleNumber ; action { textArea.text += text }})
            add(button { text = "6" ; setPrefSize(100.0 , 100.0) ; style = styleNumber ; action { textArea.text += text }})
            add(button { text = "9" ; setPrefSize(100.0 , 100.0) ; style = styleNumber ; action { textArea.text += text }})
            spacing = 2.0
        }

        val hbox2_3 = hbox {
            add(column2)
            add(column3)
            spacing = 2.0
        }

        val column2_3 = vbox {
            add(hbox2_3)
            add(button {
                text = "=" ; setPrefSize(200.0 , 100.0) ; style = "-fx-background-color: #FF2E5E; -fx-background-radius: 50 ; -fx-font-size: 25px ;" ;
                action { calculte(operator) }
            })
            spacing = 2.0
        }

        val column4 = vbox {
            val styleOperator = "-fx-background-color: #FBD712; -fx-background-radius: 50 ; -fx-font-size: 20px ;"
            add(button { text = "+" ; setPrefSize(100.0 , 100.0) ; style = styleOperator ; action { textArea.text += text ; operator = text} })
            add(button { text = "-" ; setPrefSize(100.0 , 100.0) ; style = styleOperator ; action { textArea.text += text ; operator = text}})
            add(button { text = "*" ; setPrefSize(100.0 , 100.0) ; style = styleOperator ; action { textArea.text += text ; operator = text}})
            add(button { text = "/" ; setPrefSize(100.0 , 100.0) ; style = styleOperator ; action { textArea.text += text ; operator = text}})
            spacing = 2.0
        }

        val column5 = vbox {
            val styleOperator = "-fx-background-color: #FBD712; -fx-background-radius: 50 ; -fx-font-size: 20px ;"
            add(button { text = "sin" ; setPrefSize(100.0 , 100.0) ; style = styleOperator ; action {
                action { textArea.text = functions.sinX( textArea.text.toDouble() )  }
            }})
            add(button { text = "cos" ; setPrefSize(100.0 , 100.0) ; style = styleOperator ; action {
                action { textArea.text = functions.cosX( textArea.text.toDouble() )  }
            }})
            add(button { text = "tan" ; setPrefSize(100.0 , 100.0) ; style = styleOperator ; action {
                action { action { textArea.text = functions.tanX( textArea.text.toDouble() )  } }
            }})
            add(button { text = "cot" ; setPrefSize(100.0 , 100.0) ; style = styleOperator ; action {
                action { textArea.text = functions.cotX( textArea.text.toDouble() )  }
            }})
            spacing = 2.0
        }

        val column5_5 = vbox {
            val styleOperator = "-fx-background-color: #FBD712; -fx-background-radius: 50 ; -fx-font-size: 20px ;"
            add(button { text = "^" ; setPrefSize(100.0 , 100.0) ; style = styleOperator ; action { textArea.text += text ; operator = text} })
            add(button { text = "!" ; setPrefSize(100.0 , 100.0) ; style = styleOperator ; action { textArea.text = functions.fac(textArea.text) }})
            add(button { text = "abs" ; setPrefSize(100.0 , 100.0) ; style = styleOperator ; action { textArea.text = functions.abs(textArea.text) }})
            add(button { text = "log" ; setPrefSize(100.0 , 100.0) ; style = styleOperator ; action { textArea.text += text ; operator = text }})
            spacing = 2.0
        }

        val column6 = vbox {
            val integral = "\u222B"
            add(button { text = integral ; setPrefSize(100.0 , 200.0) ;
                style = "-fx-background-color: #FBD712; -fx-background-radius: 50 ; -fx-font-size: 30px ;" ; action { Integral().openWindow() }})
            add(button { text = "Ac" ; setPrefSize(100.0 , 200.0) ;
                style = "-fx-background-color: #FF2E5E; -fx-background-radius: 50 ; -fx-font-size: 20px ;" ; action { textArea.text = "" }})
            spacing = 4.0
        }

        val keyboard = hbox{
            add(column1)
            add(column2_3)
            add(column4)
            add(column5)
            add(column5_5)
            add(column6)
            spacing = 2.0
        }

        val showBox = vbox {
            add(textArea)
            add(keyboard)
            spacing = 20.0
            paddingAll = 20.0
        }

    }
}