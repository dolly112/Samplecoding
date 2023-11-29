
package com.utilities;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

/**
 *  This Class does Image Comparison.
 	Below are the Image Testing Scenarios 
 	1.	Simple Validation 
 	2.  IMAGE PRESENT OR NOT
 	3.	IMAGE COMPARISON TESTING BETWEEN TWO IMAGES
 	4.	PIXEL COMPARISON TESTING 
 *  @author PRIYANV
 *  
 */

public class ImageComparision extends BaseInitializer {
	public static Logger LOGGER = Logger.getLogger(ImageComparision.class);

	/**
  	*  This Method does Image Comparison
 	   using isDisplayed() Function of selenium
	 *  @author PRIYANV
	 *  @param  WebElement of the Image
	 *  @return boolean(true-image is present, false-image is not present)
	 *  
	 */

	public boolean isImageDisplayed(WebElement image) {
		Boolean isPresent = image.isDisplayed();
		if (isPresent == true)
			return true;
		else
			return false;

	}

	/**
  	*  This Method does Image Comparison
 	 * using whether the image is present or not using JavaScript which checks for
	 * the arguments like Width , certain other dimensions of the Image
	 *  @author PRIYANV
	 *  @param  image - WebElement of the Image
	 *  @return boolean(true-image is present, false-image is not present)
	 *  @throws InterruptedException
	 *  
	 */

	public void isimagePresent(WebElement image) throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		Boolean imgPresent = (Boolean) (js.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				image));

		if (imgPresent == true) {
			LOGGER.debug("Image is present");
		} else {
			LOGGER.error("Image is not present");
		}
	}

	
	/**
	 * This Method does Image Comparison
	 * Using Yandel QA tool, which supports to take a screenshot of particular Web
	 * Element and compares the expected Image with Actual Image. This uses Ashot
	 * API which does Capturing the screenshot of the full page, Finding the
	 * element's size and coordinates ,Adjusting the original screenshot by cropping
	 * @author PRIYANV
	 * @param  image - WebElement of the Image
	 * @throws IOException,InterruptedException
	 */

	public void imageComparision(WebElement image) throws IOException, InterruptedException {

		Screenshot shot = new AShot().takeScreenshot(driver, image);
		File file = new File(System.getProperty("user.dir") + "\\ImageFolder\\logo.png");
		LOGGER.debug(file);
		ImageIO.write(shot.getImage(), "PNG", file);
		// Getting Expected Image 
		BufferedImage expectedImg = ImageIO.read(file);
		// Getting Actual Image 
		BufferedImage actualImg = shot.getImage();
		// Image Comparison
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff dif = imgDiff.makeDiff(expectedImg, actualImg);
		if (dif.hasDiff()) {
			LOGGER.error("Both images are different");
		} else {
			LOGGER.debug("Both images are same");
		}

	}

	
	/**
	 * This Method  performs image comparison testing pixel by pixel. (A large number of
	 * pixels together combined to make an image) user needs to provide both the
	 * expected and the actual Image Files as the input.
	 * @author PRIYNV
	 * @param imgFile1
	 * @param imgFile2
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public void imagepixelComparision(String imgFile1, String imgFile2) throws IOException, InterruptedException {
	//	 Encoding image file 
		 Image img1 =Toolkit.getDefaultToolkit().getImage(imgFile1);
		Image img2 = Toolkit.getDefaultToolkit().getImage(imgFile2);

		try {
			// Getting pixels 
			PixelGrabber pixGrab1 = new PixelGrabber(img1, 0, 0, -1, -1,false);
			PixelGrabber pixGrab2 = new PixelGrabber(img2, 0, 0, -1, -1, false);

			// Integer array to store the pixels 
			int[] dataArry1 = null;
			int[] dataArry2 = null;

			// Getting Height & Width of the pixels
			if (pixGrab1.grabPixels()) {
				int height = pixGrab1.getHeight();
				int width = pixGrab1.getWidth();
				dataArry1 = new int[width * height];
				dataArry1 = (int[]) pixGrab1.getPixels();
			}

			if (pixGrab2.grabPixels()) {
				int height2 = pixGrab2.getHeight();
				int width2 = pixGrab2.getWidth();
				dataArry2 = new int[width2 * height2];
				dataArry2 = (int[]) pixGrab2.getPixels();
			}

			LOGGER.debug("Pixel Comparison: " + Arrays.equals(dataArry1, dataArry2));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * Method for converting the SVG image to Png image
	 * @author PRIYANV
	 * @throws IOException
	 */

	public void svgTopngConverison() throws IOException { BufferedImage
		input_image = null;
		input_image = ImageIO.read(new File("Convert_to_PNG.svg"));
		// read svginto input_image object
		File outputfile = new File("imageio_png_output.png");
		// create new outputfile object
		ImageIO.write(input_image, "PNG", outputfile);
	}

}
