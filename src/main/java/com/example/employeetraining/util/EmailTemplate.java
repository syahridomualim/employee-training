package com.example.employeetraining.util;

import org.springframework.stereotype.Component;

@Component("emailTemplate")
public class EmailTemplate {
    public String getRegisterTemplate() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "\t.email-container {\n" +
                "\t\tpadding-top: 10px;\n" +
                "\t}\n" +
                "\tp {\n" +
                "\t\ttext-align: left;\n" +
                "\t}\n" +
                "\n" +
                "\ta.btn {\n" +
                "\t\tdisplay: block;\n" +
                "\t\tmargin: 30px auto;\n" +
                "\t\tbackground-color: #01c853;\n" +
                "\t\tpadding: 10px 20px;\n" +
                "\t\tcolor: #fff;\n" +
                "\t\ttext-decoration: none;\n" +
                "\t\twidth: 30%;\n" +
                "\t\ttext-align: center;\n" +
                "\t\tborder: 1px solid #01c853;\n" +
                "\t\ttext-transform: uppercase;\n" +
                "\t}\n" +
                "\ta.btn:hover,\n" +
                "\ta.btn:focus {\n" +
                "\t\tcolor: #01c853;\n" +
                "\t\tbackground-color: #fff;\n" +
                "\t\tborder: 1px solid #01c853;\n" +
                "\t}\n" +
                "\t.user-name {\n" +
                "\t\ttext-transform: uppercase;\n" +
                "\t}\n" +
                "\t.manual-link,\n" +
                "\t.manual-link:hover,\n" +
                "\t.manual-link:focus {\n" +
                "\t\tdisplay: block;\n" +
                "\t\tcolor: #396fad;\n" +
                "\t\tfont-weight: bold;\n" +
                "\t\tmargin-top: -15px;\n" +
                "\t}\n" +
                "\t.mt--15 {\n" +
                "\t\tmargin-top: -15px;\n" +
                "\t}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<div class=\"email-container\">\n" +
                "\t\t<p>Halo <span class=\"user-name\">{{USERNAME}}</span> Selamat bergabung</p>\n" +
                "\t\t<p>Please confirm your email by entering the code below\n" +
                "\n</p>\n" +
                "\t\t\n" +
                "\t\tOTP : <a href=\"{{VERIFY_TOKEN}}\" >Click Here for Activate</a>\n" +
                "\t\t\n " +
                "\t\t<p class=\"mt--15\">If you need help or questions, contact us {{HOSTMAIL}}</p>\n" +
                "\t\t\n" +
                "\t\t<p>Have a nice day!</p>\n" +
                "\t\t\n" +
                "\t\t<p>Test API Send OTP</p>\n" +
                "\t\t<p class=\"mt--15\".....</p>\n" +
                "\n" +
                "\t\t\n" +
                "\t</div>\n" +
                "</body>\n" +
                "</html>";
    }

    public String getOTPTemplate() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "\t.email-container {\n" +
                "\t\tpadding-top: 10px;\n" +
                "\t}\n" +
                "\tp {\n" +
                "\t\ttext-align: left;\n" +
                "\t}\n" +
                "\n" +
                "\ta.btn {\n" +
                "\t\tdisplay: block;\n" +
                "\t\tmargin: 30px auto;\n" +
                "\t\tbackground-color: #01c853;\n" +
                "\t\tpadding: 10px 20px;\n" +
                "\t\tcolor: #fff;\n" +
                "\t\ttext-decoration: none;\n" +
                "\t\twidth: 30%;\n" +
                "\t\ttext-align: center;\n" +
                "\t\tborder: 1px solid #01c853;\n" +
                "\t\ttext-transform: uppercase;\n" +
                "\t}\n" +
                "\ta.btn:hover,\n" +
                "\ta.btn:focus {\n" +
                "\t\tcolor: #01c853;\n" +
                "\t\tbackground-color: #fff;\n" +
                "\t\tborder: 1px solid #01c853;\n" +
                "\t}\n" +
                "\t.user-name {\n" +
                "\t\ttext-transform: uppercase;\n" +
                "\t}\n" +
                "\t.manual-link,\n" +
                "\t.manual-link:hover,\n" +
                "\t.manual-link:focus {\n" +
                "\t\tdisplay: block;\n" +
                "\t\tcolor: #396fad;\n" +
                "\t\tfont-weight: bold;\n" +
                "\t\tmargin-top: -15px;\n" +
                "\t}\n" +
                "\t.mt--15 {\n" +
                "\t\tmargin-top: -15px;\n" +
                "\t}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<div class=\"email-container\">\n" +
                "\t\t<p>Halo <span class=\"user-name\">{{USERNAME}}</span> Selamat bergabung</p>\n" +
                "\t\t<p>Harap konfirmasikan email kamu dengan memasukkan kode dibawah ini\n" +
                "\n</p>\n" +
                "\t\t\n" +
                "\t\tKode : <a>{{VERIFY_TOKEN}}</a>\n" +
                "\t\t\n " +
                "\t\t<p class=\"mt--15\">If you need help or questions, contact us {{HOSTMAIL}}</p>\n" +
                "\t\t\n" +
                "\t\t<p>Have a nice day!</p>\n" +
                "\t\t\n" +
                "\t\t<p>Test API Send OTP</p>\n" +
                "\t\t<p class=\"mt--15\".....</p>\n" +
                "\n" +
                "\t\t\n" +
                "\t</div>\n" +
                "</body>\n" +
                "</html>";
    }

    public String getResetPassword(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "\t.email-container {\n" +
                "\t\tpadding-top: 10px;\n" +
                "\t}\n" +
                "\tp {\n" +
                "\t\ttext-align: left;\n" +
                "\t}\n" +
                "\n" +
                "\ta.btn {\n" +
                "\t\tdisplay: block;\n" +
                "\t\tmargin: 30px auto;\n" +
                "\t\tbackground-color: #01c853;\n" +
                "\t\tpadding: 10px 20px;\n" +
                "\t\tcolor: #fff;\n" +
                "\t\ttext-decoration: none;\n" +
                "\t\twidth: 30%;\n" +
                "\t\ttext-align: center;\n" +
                "\t\tborder: 1px solid #01c853;\n" +
                "\t\ttext-transform: uppercase;\n" +
                "\t}\n" +
                "\ta.btn:hover,\n" +
                "\ta.btn:focus {\n" +
                "\t\tcolor: #01c853;\n" +
                "\t\tbackground-color: #fff;\n" +
                "\t\tborder: 1px solid #01c853;\n" +
                "\t}\n" +
                "\t.user-name {\n" +
                "\t\ttext-transform: uppercase;\n" +
                "\t}\n" +
                "\t.manual-link,\n" +
                "\t.manual-link:hover,\n" +
                "\t.manual-link:focus {\n" +
                "\t\tdisplay: block;\n" +
                "\t\tcolor: #396fad;\n" +
                "\t\tfont-weight: bold;\n" +
                "\t\tmargin-top: -15px;\n" +
                "\t}\n" +
                "\t.mt--15 {\n" +
                "\t\tmargin-top: -15px;\n" +
                "\t}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<div class=\"email-container\">\n" +
                "\t\t<p>If you Requested a password for {{USERNAME}}, use the confirmation code below to complete the process. If you didn't make this request, ignore the email.</p>\n" +
                "\t\t\n" +
                "\t\tCode: <b>{{PASS_TOKEN}}</b>\n" +
                "\t\t\n" +
                "\t\t\n" +
//                "\t\t<p>Regards</p>\n" +
                "\t\t<p>Test API Forgot Password</p>\n" +
                "\t\t<p class=\"mt--15\".....</p>\n" +
                "\n" +
                "\t\t\n" +
                "\t</div>\n" +
                "</body>\n" +
                "</html>";
    }

}