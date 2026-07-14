# Supernova Pro

Minecraft 1.20.4 Fabric 水晶PvP客户端。

[![Build](https://github.com/bhirapth/Supernova-Pro/actions/workflows/build.yml/badge.svg)](https://github.com/bhirapth/Supernova-Pro/actions/workflows/build.yml)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.20.4-green.svg)](https://www.minecraft.net/)

![截图](screenshot.png)

## 下载

**[最新版本](https://github.com/bhirapth/Supernova-Pro/releases/latest)**

## 功能

<details>
<summary><b>战斗</b></summary>

| 模块 | 说明 |
|------|------|
| [AutoCrystal](src/main/java/dev/luminous/mod/modules/impl/combat/AutoCrystal.java) | 自动水晶放置与引爆 |
| [AutoCrystalBase](src/main/java/dev/luminous/mod/modules/impl/combat/AutoCrystalBase.java) | 水晶底座放置辅助 |
| [AutoTrap](src/main/java/dev/luminous/mod/modules/impl/combat/AutoTrap.java) | 黑曜石困住敌人 |
| [AutoWeb](src/main/java/dev/luminous/mod/modules/impl/combat/AutoWeb.java) | 蜘蛛网陷阱 |
| [AutoLadder](src/main/java/dev/luminous/mod/modules/impl/combat/AutoLadder.java) | 自动放置梯子 |
| [AutoCity](src/main/java/dev/luminous/mod/modules/impl/combat/AutoCity.java) | 挖掘敌人黑曜石 |
| [AutoAnchor](src/main/java/dev/luminous/mod/modules/impl/combat/AutoAnchor.java) | 重生锚战斗 |
| [AutoHoleFill](src/main/java/dev/luminous/mod/modules/impl/combat/AutoHoleFill.java) | 自动填坑 |
| [PistonCrystal](src/main/java/dev/luminous/mod/modules/impl/combat/PistonCrystal.java) | 活塞水晶 |
| [BedAura](src/main/java/dev/luminous/mod/modules/impl/combat/BedAura.java) | 床战斗 |
| [KillAura](src/main/java/dev/luminous/mod/modules/impl/combat/KillAura.java) | 近战自动攻击 |
| [Surround](src/main/java/dev/luminous/mod/modules/impl/combat/Surround.java) | 自我黑曜石围困 |
| [Burrow](src/main/java/dev/luminous/mod/modules/impl/combat/Burrow.java) | 躲入方块 |

</details>

<details>
<summary><b>玩家</b></summary>

| 模块 | 说明 |
|------|------|
| [AutoGapple](src/main/java/dev/luminous/mod/modules/impl/player/AutoGapple.java) | 自动吃金苹果 |
| [AutoArmor](src/main/java/dev/luminous/mod/modules/impl/player/AutoArmor.java) | 自动装备盔甲 |
| [AutoTool](src/main/java/dev/luminous/mod/modules/impl/player/AutoTool.java) | 自动切换工具 |
| [AutoMine](src/main/java/dev/luminous/mod/modules/impl/player/AutoMine.java) | 自动挖矿 |
| [AutoPot](src/main/java/dev/luminous/mod/modules/impl/player/AutoPot.java) | 自动药水 |
| [AutoHeal](src/main/java/dev/luminous/mod/modules/impl/player/AutoHeal.java) | 自动经验瓶 |
| [AutoTrade](src/main/java/dev/luminous/mod/modules/impl/player/AutoTrade.java) | 自动村民交易 |
| [AutoPearl](src/main/java/dev/luminous/mod/modules/impl/player/AutoPearl.java) | 自动末影珍珠 |
| [Freecam](src/main/java/dev/luminous/mod/modules/impl/player/Freecam.java) | 自由视角 |
| [PacketMine](src/main/java/dev/luminous/mod/modules/impl/player/PacketMine.java) | 快速挖掘 |
| [TimerModule](src/main/java/dev/luminous/mod/modules/impl/player/TimerModule.java) | 游戏加速 |

</details>

<details>
<summary><b>移动</b></summary>

| 模块 | 说明 |
|------|------|
| [Speed](src/main/java/dev/luminous/mod/modules/impl/movement/Speed.java) | 移动加速 |
| [Fly](src/main/java/dev/luminous/mod/modules/impl/movement/Fly.java) | 飞行 |
| [Scaffold](src/main/java/dev/luminous/mod/modules/impl/movement/Scaffold.java) | 自动搭桥 |
| [Step](src/main/java/dev/luminous/mod/modules/impl/movement/Step.java) | 跨越高度 |
| [Velocity](src/main/java/dev/luminous/mod/modules/impl/movement/Velocity.java) | 击退减缓 |
| [Sprint](src/main/java/dev/luminous/mod/modules/impl/movement/Sprint.java) | 自动疾跑 |
| [HoleSnap](src/main/java/dev/luminous/mod/modules/impl/movement/HoleSnap.java) | 传送至安全坑 |

</details>

<details>
<summary><b>渲染</b></summary>

| 模块 | 说明 |
|------|------|
| [ESP](src/main/java/dev/luminous/mod/modules/impl/render/ESP.java) | 实体高亮 |
| [HoleESP](src/main/java/dev/luminous/mod/modules/impl/render/HoleESP.java) | 安全坑显示 |
| [Tracers](src/main/java/dev/luminous/mod/modules/impl/render/Tracers.java) | 实体追踪线 |
| [NameTags](src/main/java/dev/luminous/mod/modules/impl/render/NameTags.java) | 增强名牌 |
| [CrystalChams](src/main/java/dev/luminous/mod/modules/impl/render/CrystalChams.java) | 水晶透视 |
| [XRay](src/main/java/dev/luminous/mod/modules/impl/render/XRay.java) | 方块透视 |
| [Shader](src/main/java/dev/luminous/mod/modules/impl/render/Shader.java) | 后处理特效 |

</details>

<details>
<summary><b>漏洞利用</b></summary>

| 模块 | 说明 |
|------|------|
| [Blink](src/main/java/dev/luminous/mod/modules/impl/exploit/Blink.java) | 数据包冻结 |
| [PearlPhase](src/main/java/dev/luminous/mod/modules/impl/exploit/PearlPhase.java) | 穿墙珍珠 |
| [WallClip](src/main/java/dev/luminous/mod/modules/impl/exploit/WallClip.java) | 穿墙 |
| [XCarry](src/main/java/dev/luminous/mod/modules/impl/exploit/XCarry.java) | 手持容器物品 |

</details>

## 环境要求

- Minecraft 1.20.4
- Fabric Loader 0.15.7+
- Java 17+

## 构建

```bash
git clone https://github.com/bhirapth/Supernova-Pro.git
cd Supernova-Pro
./gradlew build
```

构建产物位于 `build/libs/`。

## 鸣谢

- [Aoba-MC-Hacked-Client](https://github.com/coltonk9043/Aoba-MC-Hacked-Client)
- [ThunderHack-Recode](https://github.com/Pan4ur/ThunderHack-Recode)
- [Meteor Client](https://github.com/MeteorDevelopment/meteor-client)
- [Baritone](https://github.com/cabaletta/baritone)
- [Satin](https://github.com/Ladysnake/Satin)
- [lookaround](https://github.com/qualterz/lookaround)

## 许可证

[GNU General Public License v3](LICENSE)
