package org.firstinspires.ftc.teamcode.subsystems

import com.arcrobotics.ftclib.command.SubsystemBase
import com.qualcomm.robotcore.hardware.DcMotorEx
import java.lang.Math.pow
import java.util.function.DoubleSupplier
import kotlin.math.pow
import kotlin.math.sign

class DriveSys (leftMotor : DcMotorEx, rightMotor : DcMotorEx) : SubsystemBase() {
    private val leftMotor : DcMotorEx
    private val rightMotor : DcMotorEx
    public var joystickTransformFactor = 2.0

    init {
        this.leftMotor = leftMotor
        this.rightMotor = rightMotor
    }

    fun driveWithPowers (leftPow : DoubleSupplier, rightPow : DoubleSupplier) {
        leftMotor.power = (leftPow.asDouble * sign(leftPow.asDouble)).pow(joystickTransformFactor)
        rightMotor.power = (rightPow . asDouble * sign (rightPow.asDouble)).pow(joystickTransformFactor)
    }

    fun driveArcade (forwardPow : DoubleSupplier, turnPow : DoubleSupplier) {

    }
}