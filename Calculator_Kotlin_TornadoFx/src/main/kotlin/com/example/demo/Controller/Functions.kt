package com.example.demo.Controller

import com.example.demo.view.Integral
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

class Functions {

    fun plus(numbers: List<String>) : String
    {
        var result = "" ; var num1 : String ; var num2 : String
        val n1 : Int ; val n2 : Int
        var negative = false


        if ( numbers[0][0] == '-'  && numbers[1][0] == '-'){

            val x = listOf<String>( numbers[0].substring(1) , numbers[1].substring(1) )
            var result = plus(x)
            result = result.reversed()
            result += "-"
            result = result.reversed()

            return result
        } else if ( numbers[0][0] == '-' ){

            val x = listOf<String>( numbers[0].substring(1) , numbers[1] )
            val negative = bigNumber(x)
            result = minus(x)
            if ( negative ){
                result = result.reversed()
                result += "-"
                result = result.reversed()
            }

            return result
        } else if ( numbers[1][0] == '-' ){

            val x = listOf<String>( numbers[0] , numbers[1].substring(1) )
            result = minus(x)

            return result
        }

        // make sure num2 is longer than num1
        if ( numbers[0].length > numbers[1].length ) {

            num2 = numbers[0] ; n2 = num2.length
            num1 = numbers[1] ; n1 = num1.length
        } else {

            num2 = numbers[1] ; n2 = num2.length
            num1 = numbers[0] ; n1 = num1.length
        }

        num2 = num2.reversed()
        num1 = num1.reversed()

        var carry = 0
        for ( i in 0 until n1 )
        {
            val sum = (num2[i] - '0') + (num1[i] - '0') + carry
            result += ( sum % 10 ).toString()
            carry = sum/10
        }

        for ( i in n1 until n2 )
        {
            val sum = ( num2[i] - '0' ) + carry
            result += ( sum % 10 ).toString()
            carry = sum / 10
        }

        if ( carry > 0){

            result += carry.toString()
        }

        result = result.reversed()

        if ( negative ){

            result = result.substring(1)
        }

        return result
    }

    fun minus(numbers: List<String>) : String
    {
        var num1 : String ; var num2 : String
        var result = "" ; var sum : Int
        val negative : Boolean

        if ( numbers[0][0] == '-'  && numbers[1][0] == '-'){

            val x = listOf<String>( numbers[0] , numbers[1].substring(1) )
            val result = plus(x)

            return result
        }


        if ( bigNumber(numbers) ){

            negative = false
            num1 = numbers[0]
            num2 = numbers[1]
        }else {

            negative = true
            num1 = numbers[1]
            num2 = numbers[0]
        }

        num1 = num1.reversed()
        num2 = num2.reversed()



        var carry = 0
        for ( i in num2.indices)
        {
            sum = ( num1[i] - '0' ) - ( num2[i] - '0' ) - carry

            if ( sum < 0 )
            {
                sum += 10
                carry = 1
            }else{

                carry = 0
            }

            result += sum.toString()
        }

        for ( i in num2.length until num1.length )
        {
            sum = ( num1[i] - '0' ) - carry

            if ( sum < 0 ){

                sum += 10
                carry = 1
            } else {

                carry = 0
            }

            result += sum.toString()
        }

        if ( negative )
        {
            result += "-"
        }

        result = result.reversed()

        while ( result[0] == '0' && result.length > 1 )
        {
            result = result.substring(1)
        }


        return result
    }

    private fun bigNumber(numbers: List<String>) : Boolean
    {

        if ( numbers[0].length > numbers[1].length ){
            return true
        }
        if ( numbers[1].length > numbers[0].length ){
            return false
        }

        // if both have same length
        for ( i in numbers[0].indices){

            if ( numbers[0][i] > numbers[1][i] ){
                return true
            } else if ( numbers[0][i] < numbers[1][i] ){
                return false
            }
        }

        return true
    }

    fun multi(numbers: List<String>) : String
    {
        var result = ""
        var num1 = numbers[0] ; var num2 = numbers[1]

        if ( numbers[0][0] == '-' && numbers[0][0] == '-' ){

            num1 = num1.substring(1)
            num2 = num2.substring(1)

        } else if ( numbers[0][0] == '-' ){

            num1 = num1.substring(1)

        } else if ( numbers[1][0] == '-' ){

            num2 = num2.substring(1)
        }

        num1 = num1.reversed()
        num2 = num2.reversed()

        val myArray = Array<Int>( (num1.length+num2.length) ){0}

        for ( i in num1.indices)
        {
            for ( j in num2.indices)
            {
                myArray[i+j] += ( num1[i] - '0' ) * ( num2[j] - '0' )
            }
        }

        for ( i in myArray.indices)
        {
            val digit = myArray[i] % 10
            val carry = myArray[i] / 10

            if ( i+1 < myArray.size )
            {
                myArray[i+1] = myArray[i+1] + carry
            }

            result = digit.toString() + result
        }

        while ( result.length > 1 && result[0] == '0' )
        {
            result = result.substring(1)
        }

        return result
    }

    fun divide(numbers: List<String>) : String
    {
        var x = mutableListOf<String>()
        val y = mutableListOf<String>( "0" , "1" )
        var negative = false

        if ( numbers[0][0] == '-'  && numbers[1][0] == '-' )
        {
            x = mutableListOf<String>( numbers[0].substring(1) , numbers[1].substring(1) )
            negative = false

        } else if ( numbers[0][0] == '-' )
        {
            x = mutableListOf<String>( numbers[0].substring(1) , numbers[1] )
            negative = true

        } else if ( numbers[1][0] == '-' )
        {
            x = mutableListOf<String>( numbers[0] , numbers[1].substring(1) )
            negative = true
        } else {

            x = mutableListOf<String>( numbers[0] , numbers[1] )
        }

        while ( x[0] >= "0" )
        {
            x[0] = minus(x)
            y[0] = plus(y)
        }

        if ( x[0] < "0" )
        {
            val z = listOf<String>( y[0] , "1" )
            x[0] = plus(x)
            x[0] = x[0].substring(1)
            y[0] = minus(z)
        }

        if ( negative )
        {
            y[0] = y[0].reversed()
            y[0] += "-"
            y[0] = y[0].reversed()

            if ( x[0] != "0" )
            {
                x[0] = x[0].reversed()
                x[0] += "-"
                x[0] = x[0].reversed()
            }

        }

        while ( x[0].length > 1 && x[0][0] == '0' ){

            x[0] = x[0].substring(1)
        }

        return "quotient = " + y[0] + "\nremaining = " + x[0]
    }

    fun calculate_integral(integral: Integral)
    {

        val x0 : Double = if ( integral.x0TF.text.isNullOrEmpty() ){
            0.0
        } else {
            integral.x0TF.text.toDouble()
        }

        val x1 : Double = if ( integral.x1TF.text.isNullOrEmpty() ){
            0.0
        } else {
            integral.x1TF.text.toDouble()
        }

        val x2 : Double = if ( integral.x2TF.text.isNullOrEmpty() ){
            0.0
        } else {
            integral.x2TF.text.toDouble()
        }

        val x3 : Double = if ( integral.x3TF.text.isNullOrEmpty() ){
            0.0
        } else {
            integral.x3TF.text.toDouble()
        }

        val x4 : Double = if ( integral.x4TF.text.isNullOrEmpty() ){
            0.0
        } else {
            integral.x4TF.text.toDouble()
        }

        val x5 : Double = if ( integral.x5TF.text.isNullOrEmpty() ){
            0.0
        } else {
            integral.x5TF.text.toDouble()
        }

        val x6 : Double = if ( integral.x6TF.text.isNullOrEmpty() ){
            0.0
        } else {
            integral.x6TF.text.toDouble()
        }

        val x7 : Double = if ( integral.x7TF.text.isNullOrEmpty() ){
            0.0
        } else {
            integral.x7TF.text.toDouble()
        }

        val x8 : Double = if ( integral.x8TF.text.isNullOrEmpty() ){
            0.0
        } else {
            integral.x8TF.text.toDouble()
        }

        val x9 : Double = if ( integral.x9TF.text.isNullOrEmpty() ){
            0.0
        } else {
            integral.x9TF.text.toDouble()
        }

        val x10 : Double = if ( integral.x10TF.text.isNullOrEmpty() ){
            0.0
        } else {
            integral.x10TF.text.toDouble()
        }


        val up : Double = integral.upperCase.text.toDouble()
        val low : Double = integral.lowerCase.text.toDouble()

        val result : Double

        val up_Sum : Double = ( x0*up ) + ( up.pow(2.0) * (x1/2) ) + ( up.pow(3.0) * (x2/3) ) + ( up.pow(4.0) * (x3/4) ) +
                ( up.pow(5.0) * (x4/5) ) + ( up.pow(6.0) * (x5/6) ) + ( up.pow(7.0) * (x6/7) ) +
                ( up.pow(8.0) * (x7/8) ) + ( up.pow(9.0) * (x8/9) ) + ( up.pow(10.0) * (x9/10) ) + ( up.pow(11.0) * (x10/11) )

        val low_Sum : Double = ( x0*low ) + ( low.pow(2.0) * (x1/2) ) + ( low.pow(3.0) * (x2/3) ) + ( low.pow(4.0) * (x3/4) ) +
                ( low.pow(5.0) * (x4/5) ) + ( low.pow(6.0) * (x5/6) ) + ( low.pow(7.0) * (x6/7) ) +
                ( low.pow(8.0) * (x7/8) ) + ( low.pow(9.0) * (x8/9) ) +  ( low.pow(10.0) * (x9/10) ) + ( low.pow(11.0) * (x10/11) )

        result = ( up_Sum - low_Sum )
        integral.resultTF.text = result.toString()
    }

    fun sinX(n : Double) : String
    {
        if ( n % 180.0 == 0.0 ){
            return "0.0"
        }
        val rad = ( n / 180.0 ) * PI

        return sin( rad ).toString()
    }

    fun cosX(n : Double) : String
    {
        if ( n % 90.0 == 0.0 && n% 180.0 != 0.0){
            return "0.0"
        }
        val rad = ( n / 180.0 ) * PI

        return cos( rad ).toString()
    }

    fun tanX(n : Double) : String
    {
        return ( sinX(n).toDouble() / cosX(n).toDouble() ).toString()
    }

    fun cotX(n : Double) : String
    {
        return ( cosX(n).toDouble() / sinX(n).toDouble() ).toString()
    }

    fun pow(numbers: List<String>) : String
    {
        val x = numbers[0]
        var y = numbers[1]
        var z = x

        while ( minus( mutableListOf(y,"1") ) != "0" ){

            z = multi( mutableListOf( z,x ) )
            y = minus( mutableListOf( y,"1" ) )
        }

        return z
    }

    fun fac(num : String) : String
    {
        var x = num
        var z = "1"

        while ( x != "0" )
        {
            z = multi( mutableListOf( z , x ) )
            x = minus( mutableListOf( x ,"1" ) )
        }

        return z
    }

    fun abs(num : String) : String
    {
        var x = num
        while ( x[0] == '-' ||  x[0] == '+' )
        {
            x = x.substring(1)
        }

        return x
    }



}

