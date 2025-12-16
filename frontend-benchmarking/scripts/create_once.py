import pyautogui
import time
import sys
import argparse

parser = argparse.ArgumentParser()

parser.add_argument('--total', type=int, help="Specify the total value (optional)", default=1)

args = parser.parse_args()

total = args.total

typing_delay = 0

reset_focus = (612, 140)
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

def run_iteration(iteration):
    print(f"Iteration {iteration + 1}/{total}")
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

def main():
    time.sleep(5)
    click_button(reset_focus)
    pyautogui.hotkey('ctrl', 'shift', '1')
    time.sleep(1)
    for i in range(total):
        run_iteration(i)
        if i < total - 1:
            click_button(reset_focus)
            time.sleep(1)
    time.sleep(1)
    pyautogui.hotkey('ctrl', 'shift', '2')

if __name__ == "__main__":
    main()
    print("Automation completed.")