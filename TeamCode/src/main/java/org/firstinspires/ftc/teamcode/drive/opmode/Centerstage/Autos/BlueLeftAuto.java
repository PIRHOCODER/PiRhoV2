package org.firstinspires.ftc.teamcode.drive.opmode.Centerstage.Autos;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name = "CS: BlueLeftAuto", group = "Autos")
public class BlueLeftAuto extends LinearOpMode {

    @Override
    public void runOpMode() {

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Pose2d startPose = new Pose2d(12, 62.75, Math.toRadians(270));
        drive.setPoseEstimate(startPose);

        TrajectorySequence testTrack = drive.trajectorySequenceBuilder(startPose)
                // setting the constraints for movement
                .setConstraints(SampleMecanumDrive.getVelocityConstraint(15, DriveConstants.MAX_ANG_VEL, DriveConstants.TRACK_WIDTH),
                        SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))

                // moving up to the center of the spike strip section
                .splineTo(new Vector2d(20.00, 29.75), Math.toRadians(270.00))
                .waitSeconds(0.5)

                // move to the board
                .lineTo(new Vector2d(30.00, 29.75))
                .waitSeconds(0.5)

                .lineToLinearHeading(new Pose2d(50.00, 36.00, Math.toRadians(0.00)))
                .build();


        waitForStart();
        if(isStopRequested()) return;
        drive.followTrajectorySequence(testTrack);
    }

}
