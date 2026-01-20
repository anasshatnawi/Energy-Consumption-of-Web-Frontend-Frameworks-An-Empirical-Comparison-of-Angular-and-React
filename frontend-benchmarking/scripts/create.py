import pyautogui
import time
import sys
import shutil
import os
import argparse
import gzip

parser = argparse.ArgumentParser()

parser.add_argument('--app', choices=['react', 'angular'], required=True, help="Choose 'react' or 'angular'")
parser.add_argument('--total', type=int, help="Specify the total value (optional)", default=1)

args = parser.parse_args()

total = args.total

output_folder = f"data/create/{total}/{args.app}"

if not os.path.exists(output_folder):
    os.makedirs(output_folder)

typing_delay = 0

upload_button_button = (1350, 130)

username = "carbon"
first_name = "carbon"
last_name = "carbon"
email = "carbon@carbon"
phone = "carbon"
status_option = 1

def tab():
    pyautogui.press('tab')

def write_input(text):
    pyautogui.write(text, interval=typing_delay)

def fill_input(field_coordinates, text):
    pyautogui.click(field_coordinates)
    pyautogui.write(text, interval=typing_delay)

def select_dropdown(status_option):
    pyautogui.press('down')
    time.sleep(0.1)
    for _ in range(status_option):
        pyautogui.press('down')
    tab()
    time.sleep(0.1)

def click_button(button_coordinates):
    pyautogui.click(button_coordinates)

def refresh():
    if sys.platform == 'darwin':
        pyautogui.hotkey('command', 'r')
    else:
        pyautogui.hotkey('ctrl', 'r')

def save_json(iteration):
    downloads_folder = os.path.expanduser('~/Downloads')
    files = [f for f in os.listdir(downloads_folder) if f.endswith('.gz')]
    if files:
        gz_file = os.path.join(downloads_folder, files[0])
        json_file = os.path.join(downloads_folder, files[0][:-3])
        try:
            with gzip.open(gz_file, 'rb') as f_in:
                with open(json_file, 'wb') as f_out:
                    shutil.copyfileobj(f_in, f_out)            
            destination = os.path.join(output_folder, f"{iteration + 1}.json")
            shutil.move(json_file, destination)
            time.sleep(0.5)
            try:
                os.remove(gz_file)
                print(f"Removed gz file: {gz_file}")
            except Exception as e:
                print(f"Error removing gz file: {e}")
                
            print(f"Saved JSON file to: {destination}")
        except Exception as e:
            print(f"Error processing gz file: {e}")
    else:
        print(f"No .gz files found in {downloads_folder}.")

def run_iteration(iteration):
    print(f"Iteration {iteration + 1}/{total}")
    pyautogui.hotkey('ctrl', 'shift', '1')
    time.sleep(1)
    tab()
    tab()
    tab()
    tab()
    tab()
    write_input(f"{email}{iteration:03d}.fr")
    tab()
    write_input(username)
    tab()
    write_input(first_name)
    tab()
    write_input(last_name)
    tab()
    write_input(phone)
    tab()
    select_dropdown(status_option)
    tab()
    pyautogui.press('enter')
    time.sleep(0.5)
    pyautogui.hotkey('ctrl', 'shift', '2')
    time.sleep(1)
    click_button(upload_button_button)
    time.sleep(0.5)
    tab()
    time.sleep(0.2)
    tab()
    time.sleep(0.2)
    tab()
    time.sleep(0.2)
    tab()
    time.sleep(0.2)
    tab()
    time.sleep(0.2)
    tab()
    time.sleep(0.5)
    pyautogui.press('enter')
    time.sleep(1)
    pyautogui.press('escape')
    if sys.platform == 'darwin':
        pyautogui.hotkey('command', 'w')
    else:
        pyautogui.hotkey('ctrl', 'w')
    save_json(iteration)

def main():
    time.sleep(5)
    refresh()
    for i in range(total):
        run_iteration(i)
        if i < total - 1:
            refresh()
            time.sleep(1)

if __name__ == "__main__":
    main()
    print("Automation completed.")