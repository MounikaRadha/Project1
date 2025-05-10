import ssl
from bs4 import BeautifulSoup
from urllib.request import urlopen


def scrape():

    url = "https://www.eenadu.net/world"
    ssl_context = ssl._create_unverified_context()
    page = urlopen(url, context=ssl_context)
    html = page.read().decode('utf-8')
    soup = BeautifulSoup(html, 'html.parser')
    news1 = soup.find_all("h3", class_="fnt20 article-title-rgt")
    my_data = ""
    for i in news1:
        my_data += i.text.strip() + "\n"

    print("News: by radha\n" + my_data)


if __name__ == "__main__":
    scrape()
