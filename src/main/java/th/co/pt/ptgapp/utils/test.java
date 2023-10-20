package th.co.pt.ptgapp.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 




import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class test {

	//public static void main(String[] args) throws NotFoundException, ChecksumException, FormatException, IOException {
		// TODO Auto-generated method stub
		/*InputStream barCodeInputStream = new FileInputStream("D:\\a.png");
		BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);

		LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Reader reader = new MultiFormatReader();
		Result result = reader.decode(bitmap);

		System.out.println("Barcode text is " + result.getText());
		*/
		
		/*BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream("D:\\qrcode.png")))));
        result = new MultiFormatReader().decode(binaryBitmap);
        System.out.println("QR Code : "+result.getText());
        */
       /* BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(
                    ImageIO.read(new FileInputStream("D:\\qrcode.png")))));
            Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
            System.out.println("QR Code : "+qrCodeResult.getText());
        */
	//}

}
