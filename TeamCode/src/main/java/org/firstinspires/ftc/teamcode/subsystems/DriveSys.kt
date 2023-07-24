package org.firstinspires.ftc.teamcode.subsystems

import com.arcrobotics.ftclib.command.Command
import com.arcrobotics.ftclib.command.RunCommand
import com.arcrobotics.ftclib.command.SubsystemBase
import com.qualcomm.robotcore.hardware.DcMotorEx
import org.firstinspires.ftc.teamcode.Constants.joystickTransformFactor
import java.util.function.DoubleSupplier
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sign


class DriveSys (leftMotor: DcMotorEx, rightMotor: DcMotorEx) : SubsystemBase() {
    private val leftMotor: DcMotorEx
    private val rightMotor: DcMotorEx

    init {
        this.leftMotor = leftMotor
        this.rightMotor = rightMotor
    }

    fun driveDifferential (leftPow: DoubleSupplier, rightPow: DoubleSupplier) : Command {
        return RunCommand({
            leftMotor.power = leftPow.asDouble
            rightMotor.power = rightPow.asDouble
        }, this)
    }

    fun driveArcade (forwardPow: DoubleSupplier, turnPow: DoubleSupplier) : Command {
        return RunCommand({
            leftMotor.power = forwardPow.asDouble + turnPow.asDouble
            rightMotor.power = forwardPow.asDouble - turnPow.asDouble
        }, this)
    }

    private fun joystickTransform (input: Double) : Double {
        return (1.0 / (joystickTransformFactor - 1)
                * sign(input.toFloat())
                * (joystickTransformFactor.pow(abs(input)) - 1))
    }
}