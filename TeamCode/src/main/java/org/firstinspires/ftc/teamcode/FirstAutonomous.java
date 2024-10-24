package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.TouchSensor;

@Autonomous
public class FirstAutonomous extends LinearOpMode {
    // I pray to god that whoever made the class DriveTrain made sure to set all the motors in their correct directions
    // Declared here to use later on as an object to power the motors.
    DriveTrain Pre_Mechanum_Functions_Drive_Train = new DriveTrain();
    //runtime will be used as the clock that tells the robot *when* to do what is stated
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        //modifying variables for ease of use
        int SecondsToReachSamples = 4 * 1000;

        //Initialize all the motors WHICH WE SHOULD BE DOING IN A SEPERATE COFNIG FILE ISNTEAD
        Pre_Mechanum_Functions_Drive_Train.leftFrontDrive = hardwareMap.get(DcMotor.class, "left_front_drive");
        Pre_Mechanum_Functions_Drive_Train.leftBackDrive = hardwareMap.get(DcMotor.class, "left_back_drive");
        Pre_Mechanum_Functions_Drive_Train.rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
        Pre_Mechanum_Functions_Drive_Train.rightBackDrive = hardwareMap.get(DcMotor.class, "right_back_drive");


        /*
        The end goal of this autonomous mode, is that (assuming robot starts on right side)
        the robot slams into the right wall, pushes through the samples, then goes left to position
        itself in front of 1 sample, then moves back to score it in the scoring area.

        Essentially this code just makes the robot loop in a square

        Everything then loops.
        It's really difficult to get anything real done without odometers, sensors, or a claw method.
         */

        waitForStart();
        //A second for the operator to look at the robot
        sleep(1000);
        int TimesRobotHasLooped = 0;
        while (opModeIsActive()){
            //This should make the robot move right
            Pre_Mechanum_Functions_Drive_Train.leftFrontDrive.setPower(0.5);
            Pre_Mechanum_Functions_Drive_Train.rightFrontDrive.setPower(-0.5);
            Pre_Mechanum_Functions_Drive_Train.leftBackDrive.setPower(-0.5);
            Pre_Mechanum_Functions_Drive_Train.rightBackDrive.setPower(0.5);
            //Waits 8 seconds in hopes that the robot moves all the way to the wall
            sleep(8000);
            //This should make the robot move forward
            Pre_Mechanum_Functions_Drive_Train.leftFrontDrive.setPower(0.5);
            Pre_Mechanum_Functions_Drive_Train.rightFrontDrive.setPower(0.5);
            Pre_Mechanum_Functions_Drive_Train.leftBackDrive.setPower(0.5);
            Pre_Mechanum_Functions_Drive_Train.rightBackDrive.setPower(0.5);
            //The hope is that the robot will push through the samples, after which we will push at least one sample into the scoring area
            sleep(SecondsToReachSamples + 3000);
            //This should make the robot move left
            Pre_Mechanum_Functions_Drive_Train.leftFrontDrive.setPower(-0.5);
            Pre_Mechanum_Functions_Drive_Train.rightFrontDrive.setPower(0.5);
            Pre_Mechanum_Functions_Drive_Train.leftBackDrive.setPower(0.5);
            Pre_Mechanum_Functions_Drive_Train.rightBackDrive.setPower(-0.5);
            sleep(1000 + TimesRobotHasLooped * 1000);
            //This should make the robot move backwards
            Pre_Mechanum_Functions_Drive_Train.leftFrontDrive.setPower(-0.5);
            Pre_Mechanum_Functions_Drive_Train.rightFrontDrive.setPower(-0.5);
            Pre_Mechanum_Functions_Drive_Train.leftBackDrive.setPower(-0.5);
            Pre_Mechanum_Functions_Drive_Train.rightBackDrive.setPower(-0.5);
            //We sleep this amount because it we let it run for too long, the robot will missalign itself
            sleep(SecondsToReachSamples);
            //Increase this counter so that on the next loop the robot goes for the next sample
            TimesRobotHasLooped = TimesRobotHasLooped + 1;
        }
    }
}