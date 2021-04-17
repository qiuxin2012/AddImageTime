package com.github.qiuxin2012

import java.awt.{Color, Font}
import java.io.File
import java.text.SimpleDateFormat

import javax.imageio.ImageIO


object Add2 {
  def main(args: Array[String]): Unit = {
    val inputDir = new File(args(0))
    val outputDir = new File(args(1))
    require(inputDir.exists())
    outputDir.mkdirs()
    val sdf = new SimpleDateFormat("yyyy/MM/dd")
    val date = sdf.parse(args(2))

    for (file <- inputDir.listFiles().filter(_.isFile())) {
      val image = ImageIO.read(file)
      val graphics = image.createGraphics()
      val font = new Font("ARIAL", Font.PLAIN, 30)
      graphics.setFont(font)
      graphics.setColor(Color.ORANGE)
      val currentDateandTime = sdf.format(date)
      graphics.drawString(currentDateandTime, image.getWidth - 250, image.getHeight() - 60)
      image.flush()
      ImageIO.write(image, "jpg", new File(outputDir + "/" + file.getName()))
    }

  }

}
