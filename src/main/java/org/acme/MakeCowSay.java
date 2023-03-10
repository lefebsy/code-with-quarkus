package org.acme;

import java.util.ArrayList;

public class MakeCowSay {
    private static String[] cowsayArray(String s) throws IllegalArgumentException {
        if (s.length() > 200) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> messages = new ArrayList<String>();
        int chars = 0;
        String messageToAdd = "";
        String[] messageSplit = s.split("\\s+");
        for (int i = 0; i < messageSplit.length; i++) {
            chars += messageSplit[i].length() + 1;
            if (chars > 40) {
                if (messageToAdd.equals("")) {
                    throw new IllegalArgumentException();
                }
                messages.add(messageToAdd);
                messageToAdd = "";
                i--;
                chars = 0;
            } else
                messageToAdd += messageSplit[i] + " ";
        }
        messages.add(messageToAdd);
        if (messages.size() == 1) {
            messages.add("                                       ");
        }
        ArrayList<String> tosay = new ArrayList<String>();
        tosay.add(" _________________________________________");
        for (int i = 0; i < messages.size(); i++) {
            String prefix, suffix;
            if (i == 0) {
                prefix = "/";
                suffix = "\\";
            } else if (i == messages.size() - 1) {
                prefix = "\\";
                suffix = "/";
            } else {
                prefix = suffix = "|";
            }
            String toadd = prefix + " " + messages.get(i);
            while (true) {
                if (toadd.length() > 40) {
                    toadd += " " + suffix;
                    break;
                }
                toadd += " ";
            }
            tosay.add(toadd);
        }
        tosay.add(" -----------------------------------------");
        tosay.add("        \\   ^__^");
        if (s.contains("420") || s.toLowerCase().contains("blaze"))
            tosay.add("         \\  (4oo)\\_______");
        else
            tosay.add("         \\  (oo)\\_______");
        tosay.add("            (__)\\       )\\/\\");
        tosay.add("                ||----w |");
        tosay.add("                ||     ||");
        return tosay.toArray(new String[0]);
    }

    /***
     * Wrap an array with correct carrier return line
     * @param s
     * @return
     * @throws IllegalArgumentException
     */
    public static String cowsay(String s) throws IllegalArgumentException {
        String arr[] = cowsayArray(s);
        String msg = "";
        for (String line : arr) {
            msg += line + "\n";
        }
        return msg;
    }

}
