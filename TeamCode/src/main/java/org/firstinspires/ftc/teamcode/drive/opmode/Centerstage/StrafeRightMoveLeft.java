package org.firstinspires.ftc.teamcode.drive.opmode.Centerstage;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name = "Strafe Right, Move Left", group = "Centerstage")
public class StrafeRightMoveLeft extends LinearOpMode {

    @Override
    public void runOpMode() {

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Pose2d startPose = new Pose2d(24, -48, Math.toRadians(90));

        drive.setPoseEstimate(startPose);

        TrajectorySequence testTrack = drive.trajectorySequenceBuilder(startPose)
                .strafeRight(16)
                .turn(Math.toRadians(90))
                .splineToSplineHeading(new Pose2d(24, -48), Math.toRadians(180))
                .build();



        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectorySequence(testTrack);
    }

}
