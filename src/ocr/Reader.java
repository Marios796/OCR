
package ocr;

import java.io.InputStream;
import java.io.OutputStream;

class Reader implements Runnable
{
public Reader(InputStream istrm, OutputStream ostrm) {   //κλαση Reader που ελεγχει αν εχει ολοκληρωθει το process και εμφανιζει τυχον errors και warnings κατα την εκτελεση του
      istrm_ = istrm;
      ostrm_ = ostrm;
  }
  public void run() {
      try
      {
          final byte[] buffer = new byte[1024];
          for (int length = 0; (length = istrm_.read(buffer)) != -1; )
          {
              ostrm_.write(buffer, 0, length);
          }
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
  }
  private final OutputStream ostrm_;
  private final InputStream istrm_;
}
