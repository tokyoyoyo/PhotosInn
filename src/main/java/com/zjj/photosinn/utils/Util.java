package com.zjj.photosinn.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @projectName: PhotosInn
 * @className: Util
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/22 14:04
 * @version: 1.0
 */

public class Util {

    public String getLocalIP() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("IP地址获取失败" + e.toString());
        }
        return "";

    }
}


//        try {
//            InetAddress candidateAddress = null;
//            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
//                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
//                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
//                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
//                    if (!inetAddr.isLoopbackAddress()) {
//                        if (inetAddr.isSiteLocalAddress()) {
//                            return inetAddr.getHostAddress();
//                        } else if (candidateAddress == null) {
//                            candidateAddress = inetAddr;
//                        }
//                    }
//                }
//            }
//            if (candidateAddress != null) {
//                return candidateAddress.getHostAddress();
//            }
//            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
//            return jdkSuppliedAddress.getHostAddress();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;


