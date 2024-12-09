package com.ECFObjet.utility;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Log {
    private static FileHandler fh = null;
    public static final Logger LOGGER =
            Logger.getLogger(Log.class.getName());

    public static void initializeFileHandler(String fileName, boolean append) throws IOException {
        {
            FileHandler fh = new FileHandler(fileName, append);
            LOGGER.setUseParentHandlers(false);
            LOGGER.addHandler(fh);

            fh.setFormatter(new FormatterLog());
            LOGGER.info("FileHandler initialisé avec succès.");

        }
    }
}
