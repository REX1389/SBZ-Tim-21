import  Homepage  from "./homepage"
import "./globals.css";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body>
        <Homepage/>
        {children}
      </body>
    </html>
  );
}
