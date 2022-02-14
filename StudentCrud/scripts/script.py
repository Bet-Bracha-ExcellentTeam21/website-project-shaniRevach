import requests
import argparse


def add_product(name, image_path, price):
    """
    Send a request for add product to the stock, and print the response.
    :param name: The name of the product to add.
    :param image_path: The image path of the product to add.
    :param price: The price of the product to add.
    :return:
    """
    url = "http://localhost:8070/addProductToStock"
    product_to_add = {"name": name, "image_path": image_path, "price": price}
    response = requests.post(url, data=product_to_add)
    print(response.status_code)
    print(response.text)


def remove_product(product_id):
    """
    Send a request for remove product from the stock, and print the response.
    :param product_id: The id of the product to remove.
    :return:
    """
    url = "http://localhost:8070/removeProduct"
    product_to_remove = {"id": product_id}
    response = requests.post(url, data=product_to_remove)
    print(response.text)
    print(response.status_code)


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("--add_product", help="add product to the stock", type=add_product, action="store")
    parser.add_argument("--remove_product", help="remove product from the stock", type=remove_product, action="store")
    args = parser.parse_args()


if __name__ == "__main__":
    main()


