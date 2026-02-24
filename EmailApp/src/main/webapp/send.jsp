<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Send Email</title>
</head>
<body>
  <h2>Send Email</h2>
  <form method="post" action="send">
    To: <input type="email" name="to" required /><br/><br/>
    Subject: <input type="text" name="subject" required /><br/><br/>
    Message:<br/>
    <textarea name="msg" rows="5" cols="40" required></textarea><br/><br/>
    <button type="submit">Send</button>
  </form>
</body>
</html>