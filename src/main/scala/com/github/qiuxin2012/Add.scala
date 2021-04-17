package com.github.qiuxin2012

import java.awt.Font
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date

import javax.imageio.ImageIO

import scala.util.Random

object Add {
  def main(args: Array[String]): Unit = {
    val inputDir = new File(args(0))
    val outputDir = new File(args(1))
    require(inputDir.exists())
    outputDir.mkdirs()
    val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val startTime = sdf.parse(args(2))
    val endTime = sdf.parse(args(3))

    val random = Random
    val indent = (endTime.getTime - startTime.getTime) / inputDir.listFiles().length
    var t = startTime.getTime
    for (file <- inputDir.listFiles()) {
      val image = ImageIO.read(file)
      val graphics = image.createGraphics()
      val font = new Font("ARIAL", Font.PLAIN, 10)
      graphics.setFont(font)
      val currentDateandTime = sdf.format(new Date(t + random.nextInt(indent.toInt)))
      graphics.drawString(currentDateandTime, image.getWidth - 120, image.getHeight() - 20)
      image.flush()
      ImageIO.write(image, "jpg", new File(outputDir + "/" + file.getName()))
      t += indent
    }

  }

}
