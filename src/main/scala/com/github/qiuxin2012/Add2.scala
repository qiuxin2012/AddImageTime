package com.github.qiuxin2012

import java.awt.{Color, Font}
import java.io.File
import java.text.SimpleDateFormat

import javax.imageio.ImageIO


object Add2 {
  def main(args: Array[String]): Unit = {
    val inputDir = new File("D:\\Newfolder")
    val outputDir = new File("C:\\Users\\xinqiu\\Downloads\\a") // new File(args(1))
    require(inputDir.exists())
    outputDir.mkdirs()
    val sdf = new SimpleDateFormat("yyyy/MM/dd")
    val date = sdf.parse("2024/10/28")

    for (file <- inputDir.listFiles().filter(_.isFile())) {
      val image = ImageIO.read(file)
      val graphics = image.createGraphics()
      val font = new Font("ARIAL", Font.PLAIN, 35)
      graphics.setFont(font)
      graphics.setColor(Color.ORANGE)
      val currentDateandTime = sdf.format(date)
      graphics.drawString(currentDateandTime, image.getWidth - 250, image.getHeight() - 60)
      image.flush()
      ImageIO.write(image, "jpg", new File(outputDir + "/" + file.getName()))
    }

  }

}
